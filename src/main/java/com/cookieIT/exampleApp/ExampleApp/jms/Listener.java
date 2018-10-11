package com.cookieIT.exampleApp.ExampleApp.jms;

import com.cookieIT.exampleApp.ExampleApp.common.mapper.messageMapper.CountryMessageToDTOMapper;
import com.cookieIT.exampleApp.ExampleApp.domain.service.CountryService;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
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

//    @JmsListener(destination = "inbound.queue")
//    //    @SendTo("outbound.queue")
//    public void createCountryMessage(final Message jsonMessage) throws JMSException {
//
//        if (jsonMessage instanceof TextMessage) {
//            countryService.createCountry(countryMessageToDTOMapper.map(jsonMessage));
//        }
//
//        //        return null;
//    }
//
//    @JmsListener(destination = "inbound.queue")
//    //    @SendTo("outbound.queue")
//    public void printMessage(final Message jsonMessage) throws JMSException {
//
//        System.out.println("Received queue message to another jmslistener" + jsonMessage);
//
//    }
//
//    @JmsListener(destination = "inbound.topic")
////    @SendTo("outbound.topic")
//    public void rcreateCountryFromTopic(final Message jsonMessage) throws JMSException {
//        if(jsonMessage instanceof TextMessage) {
//            countryService.createCountry(countryMessageToDTOMapper.map(jsonMessage));
//        }
//    }
//
//    @JmsListener(destination = "inbound.topic")
//    //    @SendTo("outbound.topic")
//    public void receiveMessageFromTopic(final Message jsonMessage) throws JMSException {
//        if(jsonMessage instanceof TextMessage) {
//            System.out.println("Received topic message to another jmslistener" + jsonMessage);
//        }
//    }

}
