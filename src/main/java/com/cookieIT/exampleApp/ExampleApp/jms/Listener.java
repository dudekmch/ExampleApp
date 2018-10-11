package com.cookieIT.exampleApp.ExampleApp.jms;

import com.cookieIT.exampleApp.ExampleApp.common.mapper.messageMapper.CountryMessageToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Listener {

    private CountryService countryService;
    private CountryMessageToDTOMapper countryMessageToDTOMapper;

    public Listener(CountryService countryService, CountryMessageToDTOMapper countryMessageToDTOMapper) {
        this.countryService = countryService;
        this.countryMessageToDTOMapper = countryMessageToDTOMapper;
    }

    @JmsListener(destination = "inbound.queue")
    @SendTo("outbound.queue")
    public Long createCountryMessage(final Message jsonMessage) throws JMSException {

        System.out.println("Received message " + jsonMessage);
        if(jsonMessage instanceof TextMessage) {
            return countryService.createCountry(countryMessageToDTOMapper.map(jsonMessage));
        }

        return null;
    }

//    @JmsListener(destination = "inbound.topic")
//    @SendTo("outbound.topic")
//    public String receiveMessageFromTopic(final Message jsonMessage) throws JMSException {
//        String messageData = null;
//        System.out.println("Received message " + jsonMessage);
//        String response = null;
//        if(jsonMessage instanceof TextMessage) {
//            TextMessage textMessage = (TextMessage)jsonMessage;
//            messageData = textMessage.getText();
//            Map map = new Gson().fromJson(messageData, Map.class);
//            response  = "Hello " + map.get("name");
//        }
//        return response;
//    }

}
