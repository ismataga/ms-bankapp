package az.ingress.msBankApp.service;

import az.ingress.msBankApp.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudents(String name,String surname);
    List<Student> getStudents(String name,String surname,String age,String string);
}
