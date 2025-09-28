package com.demo.springboot.cruddemo.service;

import com.demo.springboot.cruddemo.dao.IEmployeeRepository;
import com.demo.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeDAO) {
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Did not find employee with id " + id)
        );
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}
