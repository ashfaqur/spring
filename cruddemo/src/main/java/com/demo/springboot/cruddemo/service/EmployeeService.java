package com.demo.springboot.cruddemo.service;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }
}
