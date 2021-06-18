package com.mohsinkd786.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohsinkd786.dtos.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSnsPublisherService {

    private AmazonSNSClient amazonSNSClient;

    @Value("${cloud.aws.sns.topic-arn}")
    private String topicArn;

    private static final Logger log = LoggerFactory.getLogger(MessageSnsPublisherService.class);

    @Autowired
    public void setAmazonSNSClient(AmazonSNSClient amazonSNSClient) {
        this.amazonSNSClient = amazonSNSClient;
    }

    public boolean sendMessageToTopic(Message message){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String payload = mapper.writeValueAsString(message);
            // publish message to sns topic
            final PublishRequest publishRequest = new PublishRequest(topicArn,payload);
            amazonSNSClient.publish(publishRequest);

        }catch (JsonProcessingException jpe){
            log.error("Unable to parse the object "+jpe);
        }
        return true;
    }

    public boolean addSubscriber(String email){
        final SubscribeRequest subscribeRequest= new SubscribeRequest(topicArn,"email",email);
        amazonSNSClient.subscribe(subscribeRequest);
        return true;
    }
}
