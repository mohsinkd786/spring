package com.mohsinkd786.service.sqs.publisher;

import com.mohsinkd786.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserPublisher extends AwsSqsService{

    @Value("${cloud.aws.endpoint}")
    private String endpoint;

    public boolean sendMessage(final UserDto userDto){
        logger.info("New User Object ",userDto.toString());
        queueMessagingTemplate.convertAndSend(endpoint, MessageBuilder.withPayload(userDto).build());
        return true;
    }
}
