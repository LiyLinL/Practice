package com.liy.generator.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;

@Component
public class jmsConsumer {

    @Autowired
    private jmsService jmsService;

    //    @JmsListener(id = "consumerMessage", destination = "test1", containerFactory = "jmsListenerContainerQueue")
//    @Async
    public void consumerMessage( ActiveMQTextMessage text ) throws JMSException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Jackson j = objectMapper.readValue(text.getText(), Jackson.class);
//        System.out.println(Thread.currentThread().getName() + "=====" + text.getText() + "====TEST1====" + new Date());
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//        }
//        j.setSome("C");
//        j.setAlways("D");
//        String s = objectMapper.writeValueAsString(j);
//        jmsService.sendTemp(text.getReplyTo(), "{\"RESULT\":\"2\",\"MESSAGE\":\"ERROR Not 1!!!!!!!!!!\"}");
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//        }
    }

    //    @JmsListener(id = "consumerMessage2", destination = "remote.command.process", containerFactory = "jmsListenerContainerQueue")
//    @Async
    public void consumerMessage2( ActiveMQTextMessage text ) throws JMSException, IOException {
        jmsService.sendTemp(text.getReplyTo(), "{\"RESULT\":\"2\", \"MESSAGE\":\"TEST_ERROR\"}");
    }
}
