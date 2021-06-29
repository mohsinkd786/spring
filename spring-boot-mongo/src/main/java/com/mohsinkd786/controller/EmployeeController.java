package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Employee;
import com.mohsinkd786.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findEmployees(){
        return employeeService.findEmployees();
    }

    @GetMapping("/filterBySalary/{gte}/{lte}")
    public List<Employee> findEmployeesBySalary(@PathVariable double gte, @PathVariable double lte){
        return employeeService.findEmployeesBySalaryRange(gte,lte);
    }

    @GetMapping("/filter/{eId}")
    public Employee findEmployeeById(@PathVariable String eId){
        return employeeService.findEmployeeById(eId);
    }

    @GetMapping("/search/{name}")
    public List<Employee> findByFirstName(@PathVariable String name){
        return employeeService.findByFirstName(name);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping
    public boolean deleteEmployee(@PathVariable String eId){
        return employeeService.deleteEmployee(eId);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
}
