package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path="members")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
