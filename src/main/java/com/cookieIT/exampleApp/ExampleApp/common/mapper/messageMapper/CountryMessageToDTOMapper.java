package com.cookieIT.exampleApp.ExampleApp.common.mapper.messageMapper;

import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import org.apache.activemq.Message;

import javax.jms.JMSException;

public interface CountryMessageToDTOMapper {

    CountryDTO map(Message jsonMessage) throws JMSException;
}
