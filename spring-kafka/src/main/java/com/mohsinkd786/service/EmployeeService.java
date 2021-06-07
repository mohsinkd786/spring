package com.mohsinkd786.service;

import com.mohsinkd786.service.kafka.publisher.EmployeePublisher;
import com.mohsinkd786.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeePublisher employeePublisher;

    @Autowired
    public void setEmployeePublisher(EmployeePublisher employeePublisher) {
        this.employeePublisher = employeePublisher;
    }

    public boolean saveEmployee(Employee employee){
        employeePublisher.sendEmployee(employee);
        return true;
    }
}
