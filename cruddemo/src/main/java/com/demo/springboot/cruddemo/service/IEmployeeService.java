package com.demo.springboot.cruddemo.service;

import com.demo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
