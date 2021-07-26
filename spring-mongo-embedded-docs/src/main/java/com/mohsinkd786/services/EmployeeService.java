package com.mohsinkd786.services;

import com.mohsinkd786.dtos.Employee;
import com.mohsinkd786.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Employee save(Employee employee){
        return repository.save(employee);
    }
    public Employee findById(String id){
        Optional<Employee> optional = repository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }
    public boolean delete(String id){
        Employee found = findById(id);
        if(found !=null){
            repository.delete(found);
        }else
        {
            return false;
        }
        return true;
    }
    public List<Employee> findEmployeesByCity(String city){
        return repository.findEmployeesByCity(city);
    }
}
