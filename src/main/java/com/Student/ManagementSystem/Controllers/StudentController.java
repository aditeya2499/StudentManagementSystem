package com.Student.ManagementSystem.Controllers;

import com.Student.ManagementSystem.Entity.Student;
import com.Student.ManagementSystem.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle requests and return list
    @GetMapping("/students")
    public String getStudents(Model m) {
        m.addAttribute("students",studentService.getAllStudents());
        return "students";
    }


    //Creating a new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        //creating empty student object to hold data
        Student student = new Student();
        model.addAttribute("student",student); // Attribute name will be added in the html file
        return "create_student";
    }

    /*
    The @ModelAttribute annotation binds a method parameter or method return
    value to a named model attribute and then exposes it to a web view. Here we are getting "student"
    object from create students.html file, and now we are binding it to use and save it.
    */
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }


    //Updating a student
    /*
    @PathVariable annotation can be used to handle template variables in the request
    URI mapping, and set them as method parameters.
    */
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));// here we are first getting the student by id and then storing that data
        // in attributeName of "student" which will be used inside edit_student.html
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    // handler method to delete student

    @GetMapping("/students/{id}")// here we need to get this id value so for that we will use path variable
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
