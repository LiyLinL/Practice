package com.liy.generator;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private JmsListenerEndpointRegistry endpointRegistry;

    @GetMapping("jms/stop")
    public void listenStop() {
        endpointRegistry.getListenerContainers().forEach(container -> {
            if (container.isRunning()) {
                container.stop();
            }
        });
    }

    @GetMapping("jms/start")
    public void listenStart() {
        endpointRegistry.getListenerContainers().forEach(container -> {
            DefaultMessageListenerContainer jmsListenerContainer = (DefaultMessageListenerContainer) container;
            if (jmsListenerContainer.isRunning()) {
                jmsListenerContainer.stop();
                jmsListenerContainer.shutdown();
                String url = "failover://(tcp://localhost:61626,tcp://localhost:61646)?maxReconnectAttempts=0&startupMaxReconnectAttempts=5&maxReconnectDelay=10000";
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
                connectionFactory.setUserName("admin");
                connectionFactory.setPassword("admin");
                connectionFactory.setBrokerURL(url);
                jmsListenerContainer.setConnectionFactory(connectionFactory);
                jmsListenerContainer.setDestinationName("Q");
                jmsListenerContainer.initialize();
                jmsListenerContainer.start();
            }
        });
    }
}
