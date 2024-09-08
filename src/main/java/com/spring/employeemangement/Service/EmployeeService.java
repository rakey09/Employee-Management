package com.spring.employeemangement.Service;
import com.spring.employeemangement.Entity.Employee;
import java.util.List;

public interface EmployeeService {

    // Save or update an employee in the database
    void save(Employee employee);

    // Find an employee by their ID
    Employee findById(int id);

    // Return a list of all employees
    List<Employee> findAll();

    // Delete an employee by their ID
    void delete(int id);
}

