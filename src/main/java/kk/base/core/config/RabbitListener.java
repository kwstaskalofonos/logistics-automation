package kk.base.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


public class RabbitListener {

    private final Logger logger = LoggerFactory.getLogger(RabbitListener.class);

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "main-queue")
    public void onUserKapa(){
        logger.info("Connected to queue");
    }
}
