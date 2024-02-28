package az.ingress.msBankApp.controller;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    StudentService studentService;

    @PostMapping
    Student addStudent(Student student){
       return studentService.addStudent(student);
    }

}