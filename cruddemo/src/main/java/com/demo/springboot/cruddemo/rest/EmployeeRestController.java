package com.demo.springboot.cruddemo.rest;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;
import com.demo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployee(@PathVariable int employeeId){
        Employee employee = this.employeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = this.employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = this.employeeService.save(employee);
        return  employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        this.employeeService.deleteById(employeeId);
    }


}
