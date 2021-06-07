package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Employee;
import com.mohsinkd786.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    //private EmployeeService employeeService;

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private RestTemplate restTemplate;

    @Value("${producer.service.url}")
    private String producerServiceUrl;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Employee> findEmployees(){
        logger.info("Find Employees...  ");
        ResponseEntity<List> responseEntity= restTemplate.getForEntity(producerServiceUrl,List.class);
        List<Employee> employees = responseEntity.getBody();
        logger.info("Employees " + employees.size());

        return employees;
    }
//    @Autowired
//    public void setEmployeeService(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

//    @GetMapping
//    public List<Employee> findEmployees(){
//        return employeeService.findEmployees();
//    }
}
