package com.demo.springboot.cruddemo.dao;

import com.demo.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO implements IEmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = this.entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        this.entityManager.remove(employee);
    }
}
