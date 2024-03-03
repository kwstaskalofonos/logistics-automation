package kk.base.core.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SimpleRoutingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class RabbitmqConfig {

    private final CachingConnectionFactory cachingConnectionFactory;
    public static final String exchangeName="message-exchange";
    public static final String customerQueue="customer-queue";
    public static final String logisticsQueue="logistics-queue";
    public static final String storageQueue="storage-queue";

    public RabbitmqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    @Bean
    @Qualifier("customerQueue")
    public Queue customerQueue(){
        return new Queue(customerQueue);
    }

    @Bean
    @Qualifier("logisticsQueue")
    public Queue logisticsQueue(){
        return new Queue(logisticsQueue);
    }

    @Bean
    @Qualifier("storageQueue")
    public Queue storageQueue(){ return new Queue(storageQueue); }

    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(exchangeName);
    }

    @Bean
    @Qualifier("bindingCustomerQueue")
    public Binding binding(@Qualifier("customerQueue") Queue customerQueue, FanoutExchange exchange){
        return BindingBuilder.bind(customerQueue).to(exchange);
    }

    @Bean
    @Qualifier("bindingLogisticsQueue")
    public Binding bindingLogisticsQueue(@Qualifier("logisticsQueue") Queue logisticsQueue, FanoutExchange exchange){
        return BindingBuilder.bind(logisticsQueue).to(exchange);
    }

    @Bean
    @Qualifier("bindingStorageQueue")
    public Binding bindingStorageQueue(@Qualifier("storageQueue") Queue storageQueue, FanoutExchange exchange){
        return BindingBuilder.bind(storageQueue).to(exchange);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        return messageConverter;
    }

    @Bean
    RabbitTemplate template(Jackson2JsonMessageConverter jackson2JsonMessageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
        return rabbitTemplate;
    }

}
