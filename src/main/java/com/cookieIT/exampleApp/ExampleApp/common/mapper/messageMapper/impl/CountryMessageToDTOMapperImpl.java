package com.cookieIT.exampleApp.ExampleApp.common.mapper.messageMapper.impl;

import com.cookieIT.exampleApp.ExampleApp.common.Currency;
import com.cookieIT.exampleApp.ExampleApp.common.dto.CountryDTO;
import com.cookieIT.exampleApp.ExampleApp.common.mapper.messageMapper.CountryMessageToDTOMapper;
import com.google.gson.Gson;
import org.apache.activemq.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class CountryMessageToDTOMapperImpl implements CountryMessageToDTOMapper {

    @Override public CountryDTO map(Message jsonMessage) throws JMSException {
        String messageData = null;

        TextMessage textMessage = (TextMessage) jsonMessage;
        messageData = textMessage.getText();
        Map map = new Gson().fromJson(messageData, Map.class);

        return mapGsonToDTO(map);

    }

    private CountryDTO mapGsonToDTO(Map map) {
        return CountryDTO.CountryDTOBuilder.aCountryDTO()
                .withName((String) map.get("name"))
                .withCapital((String) map.get("capital"))
                .withCurrency(Currency.valueOf((String) map.get("currency")))
                .withPopulation(Long.valueOf((String) map.get("population")))
                .build();
    }
}
