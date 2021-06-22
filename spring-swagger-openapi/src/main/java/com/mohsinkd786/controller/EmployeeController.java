package com.mohsinkd786.controller;

import com.mohsinkd786.dtos.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(description = "Employee list retrived")
    })
    @GetMapping
    public List<Employee> getEmployees(){
        return null;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return null;
    }
}
