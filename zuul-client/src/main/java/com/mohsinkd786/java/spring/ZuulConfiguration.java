package com.mohsinkd786.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mohsinkd786.java.spring.filters.PreFilter;

@Configuration
public class ZuulConfiguration {

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
}
