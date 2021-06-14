package com.mohsinkd786.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.mohsinkd786.config.settings.AwsSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSqsConfig {

    @Autowired
    private AwsSetting awsSetting;

    public AmazonSQSAsync amazonSQSAsync(){
        AmazonSQSAsyncClientBuilder amazonSQSAsyncClientBuilder= AmazonSQSAsyncClientBuilder.standard();


        amazonSQSAsyncClientBuilder.withRegion(awsSetting.getRegion());
        amazonSQSAsyncClientBuilder.withCredentials(
                new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(
                                awsSetting.getAccessKey(),
                                awsSetting.getSecretKey())));

        AmazonSQSAsync amazonSQSAsync = amazonSQSAsyncClientBuilder.build();
        return amazonSQSAsync;
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(){
        return new QueueMessagingTemplate(amazonSQSAsync());
    }
}
