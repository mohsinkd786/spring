package com.mohsinkd786.java.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {

	@Value("${spring.mongo.host}")
	private String mongoHost;

	@Value("${spring.mongo.db}")
	private String mongoDB;

	@Bean
	public MongoClient mongoClient() {
		MongoClient mongo = new MongoClient(mongoHost);
		return mongo;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate template = new MongoTemplate(mongoClient(), mongoDB);
		return template;
	}
}
