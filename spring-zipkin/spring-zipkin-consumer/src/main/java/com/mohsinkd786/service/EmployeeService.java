package com.mohsinkd786.service;

import com.mohsinkd786.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    private RestTemplate restTemplate;

    @Value("${producer.service.url}")
    private String producerServiceUrl;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> findEmployees(){
        ResponseEntity<List>  responseEntity= restTemplate.getForEntity(producerServiceUrl,List.class);
        List<Employee> employees = responseEntity.getBody();

        return employees;
    }
}
