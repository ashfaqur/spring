package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
