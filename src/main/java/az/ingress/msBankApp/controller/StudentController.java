package az.ingress.msBankApp.controller;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.model.SearchCriteria;
import az.ingress.msBankApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/studentByName/{name}")
    public Student getStudentByName(@PathVariable String name) {
        System.out.println(name);
        return studentService.getStudentByName(name);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/student/{id}")
    public Student deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }


    @PostMapping
    Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/student")
    public ResponseEntity<List<Student>> findAllStudents(@RequestBody List<SearchCriteria> searchCriteriaList) {
        return ResponseEntity.ok(studentService.findAllStudents(searchCriteriaList));
    }

    @GetMapping("/student/all")
    public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAllStudents(pageable));
    }

    @GetMapping("/student/allPages")
    public ResponseEntity<Page<Student>> getAllStudentsPage(@RequestParam(value = "pageSize") int pageSize,
                                                            @RequestParam(value = "pageNumber") int pageNumber,
                                                            @RequestParam(value = "pageSort") String[] pageSort
    ) {
        return ResponseEntity.ok(studentService.getAllStudentsPage(pageSize, pageNumber, pageSort));

    }

}