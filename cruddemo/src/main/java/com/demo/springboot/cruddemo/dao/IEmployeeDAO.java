package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> findAll();
}
