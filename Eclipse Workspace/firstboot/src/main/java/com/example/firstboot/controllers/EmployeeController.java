package com.example.firstboot.controllers;


import com.example.firstboot.model.Employee;
import com.example.firstboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee( @RequestBody Employee employee){
        System.out.println(employee);
        return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        System.out.println(id);
        return employeeService.getById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        System.err.println("for Deleting "+  id);
        if(employeeService.delete(id))
            return "deleted successfully";
        return "id not found";
    }
}
