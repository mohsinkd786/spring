package com.mohsinkd786.service.sqs.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

public abstract class AwsSqsService {

    protected QueueMessagingTemplate queueMessagingTemplate;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public void setQueueMessagingTemplate(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }
}
