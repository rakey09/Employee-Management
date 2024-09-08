package com.spring.employeemangement.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the primary key value
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")  // Map to the 'first_name' column in the employees table
    private String firstName;

    @Column(name = "last_name")   // Map to the 'last_name' column in the employees table
    private String lastName;

    @Column(name = "email")  // Map to the 'email' column
    private String email;

    @CreationTimestamp   // Automatically set the creation timestamp when the record is inserted
    @Column(name = "created_at", updatable = false)  // Mark 'created_at' as non-updatable
    private LocalDateTime createdAt;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
