package az.ingress.msBankApp.service;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.model.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
public interface StudentService {

    Student addStudent(Student student);
    List<Student> getStudents(String name,String surname,String age,String string);

    List<Student> findAllStudents(List<SearchCriteria> searchCriteriaList);


    Page getAllStudents(Pageable pageable);

    Page<Student> getAllStudentsPage(int pageSize, int pageNumber, String[] pageSort);
}
