package com.mohsinkd786.resources;

import com.mohsinkd786.dtos.Employee;
import com.mohsinkd786.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeResource {

    private EmployeeService service;

    @Autowired
    public void setService(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return service.save(employee);
    }

    @GetMapping("{id}")
    public Employee findById(@PathVariable String id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable String id){
       return service.delete(id);
    }

    @PostMapping("/filter")
    public List<Employee> findByCity(@RequestBody String city){
        return service.findEmployeesByCity(city);
    }
}
