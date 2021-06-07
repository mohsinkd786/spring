package com.mohsinkd786.config;

import com.mohsinkd786.filter.ErrorFilter;
import com.mohsinkd786.filter.PostFilter;
import com.mohsinkd786.filter.PreFilter;
import com.mohsinkd786.filter.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public PreFilter preFilter(){
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }

    @Bean
    public RouteFilter routeFilter(){
        return new RouteFilter();
    }
}
