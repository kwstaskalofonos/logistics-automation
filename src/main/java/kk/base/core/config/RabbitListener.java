package kk.base.core.config;

import org.springframework.stereotype.Component;

import static kk.base.core.config.RabbitmqConfig.*;

//@Component
public class RabbitListener {

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {customerQueue})
    public void customerListener(String message) {

    }
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {logisticsQueue})
    public void logisticsListener(String message) {

    }
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = {storageQueue})
    public void storageListener(String message) {

    }
}
