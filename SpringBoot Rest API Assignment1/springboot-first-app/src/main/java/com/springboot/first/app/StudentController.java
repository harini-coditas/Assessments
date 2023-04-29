package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Harini", "Bathini");
    }

   // http://localhost:8080/student/firstName/lastName
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harini", "Bathini"));
        students.add(new Student("Shreya","Kalluraya"));
        students.add(new Student("Aniket", "Mote"));
        students.add(new Student("Yash","Paliwal"));
        students.add(new Student("Tanmay", "Bodke"));
        students.add(new Student("Sujan","Shaik"));
        return students;
    }
    // http:localhost:8080/student/harini/bathini
    //@PathVariable annotation
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        return new Student(firstName,lastName);
    }

    // build rest API to handle query parameters
    // http://localhost:8080/student?firstName=Harini&lastName=Bathini
    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,@RequestParam(name = "lastName") String lastName){
        return new Student(firstName,lastName);
    }

}
