package com.mohsinkd786.service;

import com.mohsinkd786.dto.Employee;
import com.mohsinkd786.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findEmployees(){
        List<Employee> employees = employeeRepository.findFirstNameAndExcludeEmployeeId();
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeesBySalaryRange(double salaryGte, double salaryLte){
        return employeeRepository.findEmploysBySalaryBetween(salaryGte,salaryLte);
    }

    public Employee createEmployee(Employee employee){
        List<Employee> employees = findEmployees();
        int size = employees.size();
        employee.setId(size+1);
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(String eId){
        employeeRepository.deleteById(eId);
        return true;
    }

    public Employee findEmployeeById(String eId){
        return employeeRepository.findByEmployeeId(eId);
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> optional = employeeRepository.findById(employee.getEmployeeId());
        if(optional.isPresent()){
            Employee employee1 = optional.get();
            employee1.setEmail(employee.getEmail());
            employee1.setFirstName(employee.getFirstName());
            employee1.setSalary(employee.getSalary());
            employeeRepository.save(employee1);
        }
        return employee;
    }

    public List<Employee> findByFirstName(String name){
        return employeeRepository.findEmployByFirstName(name);
    }
}
