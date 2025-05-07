package com.example.firstboot.services;


import com.example.firstboot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public Employee save(Employee employee) {
        employeeList.add(employee);
        System.out.println(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee getById(int id) {
        Optional<Employee> emp = employeeList.stream().filter(n -> n.getEmpId() == id).findFirst();
        return emp.orElse(null);
    }

    public boolean delete(int id) {
        Employee emp = getById(id);
        if(emp==null){
            return false;
        }
        employeeList.remove(emp);
        return true;
    }
}
