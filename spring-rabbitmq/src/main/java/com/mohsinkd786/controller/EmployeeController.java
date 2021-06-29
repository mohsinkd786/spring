package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Employee;
import com.mohsinkd786.dto.User;
import com.mohsinkd786.service.EmployeeService;
import com.mohsinkd786.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public void setUserService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public String sendEmployeeToQueue(@RequestBody Employee employee){
        employeeService.sendMessage(employee.toString());
        return "Employee processed successfully";
    }
}
