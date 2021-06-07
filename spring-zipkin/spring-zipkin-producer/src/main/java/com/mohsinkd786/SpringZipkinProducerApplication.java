package com.mohsinkd786;

import brave.sampler.RateLimitingSampler;
import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringZipkinProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinProducerApplication.class, args);
	}

	@Bean
	public Sampler sampler(){
			return RateLimitingSampler.ALWAYS_SAMPLE;
	}
}
