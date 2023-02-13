package com.Student.ManagementSystem.Repository;

import com.Student.ManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
Actually we dont need to add @Repository here because JpaRepository has that annotation already and we are extending it
Jpa Repository has two parameters, first is Type of Entity and 2nd is Type of Primary Key, here our primary key was of
long type
Simple Jpa Repository is the implementaion class for JpaRepository interface and all the methods are by default @Transactional
*/
public interface StudentRepository extends JpaRepository<Student,Long > {
}
