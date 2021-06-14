package com.mohsinkd786.service.sqs.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohsinkd786.dto.UserDto;
import com.mohsinkd786.service.sqs.publisher.AwsSqsService;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class UserListener extends AwsSqsService {


    //@SqsListener("ibm-queue")
    public void receiveMessage(String message){
        try {
            logger.info("UserListener ****** ",message);
            // parse the payment
            ObjectMapper mapper=new ObjectMapper();
            UserDto userDto = mapper.readValue(message, UserDto.class);

        }catch (JsonProcessingException ex){
            logger.error(ex.getMessage());
        }
    }
}
