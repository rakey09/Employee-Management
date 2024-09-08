package com.spring.employeemangement.Service;

import com.spring.employeemangement.DAO.EmployeeRepository;
import com.spring.employeemangement.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Marks this class as a service, allowing Spring to manage it as a bean
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired  // Constructor-based dependency injection for EmployeeRepository
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);  // Save or update an employee
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optional = repository.findById(id);

        // If employee is found, return it; otherwise, throw an exception
        return optional.orElseThrow(() ->
                new RuntimeException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();  // Retrieve all employees
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);  // Delete employee by ID
    }
}
