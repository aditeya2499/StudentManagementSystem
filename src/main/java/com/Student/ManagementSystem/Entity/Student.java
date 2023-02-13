package com.Student.ManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id//Adding a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adding a primary key generation strategy
    private Long id;
    @Column(name = "first_name", nullable = false)//Even if we dont write @Column annotation jpa is smart enough to give column names automatically
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    public Long getId() {
        return id;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(Long id) {
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
}
