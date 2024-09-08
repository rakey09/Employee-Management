package com.spring.employeemangement.Controller;

import com.spring.employeemangement.Entity.Employee;
import com.spring.employeemangement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired  // Constructor-based injection for EmployeeService
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Show the form for creating a new employee
    @GetMapping("/create")
    public String createForm(Model model) {
        Employee employee = new Employee();  // Create an empty Employee object for binding
        model.addAttribute("employee", employee);
        return "Creation-Form";  // Returns the view for the creation form
    }

    // Show the list of employees
    @GetMapping("/list")
    public String list(Model model) {
        List<Employee> employees = service.findAll();  // Retrieve all employees
        model.addAttribute("Employees", employees);    // Add the list to the model
        return "Home";  // Return the view displaying employee list
    }

    // Show the form for updating an employee's details
    @PostMapping("/formForUpdate")
    public String formForUpdate(@RequestParam("id") int id, Model model) {
        Employee employee = service.findById(id);  // Find employee by ID
        model.addAttribute("employee", employee);  // Add the employee to the model
        return "Creation-Form";  // Return the view for the update form (reuses creation form)
    }

    // Save or update an employee's information
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        service.save(employee);  // Save or update the employee
        return "redirect:/employees/list";  // Redirect to the list after saving
    }

    // Delete an employee by ID
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.delete(id);  // Delete employee by ID
        return "redirect:/employees/list";  // Redirect to the list after deletion
    }
}

