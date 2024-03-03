package kk.base.core.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    @RabbitListener(queues = "main-queue")
    public void receiveMessages(){

    }
}
