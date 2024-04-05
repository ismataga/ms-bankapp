package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.model.SearchCriteria;
import az.ingress.msBankApp.repository.StudentRepository;
import az.ingress.msBankApp.service.StudentService;
import az.ingress.msBankApp.spec.StudentSpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }



    //CriteriaBuilder

    public List<Student> getAllStudent(String name, String surname) {
        Specification<Student> studentSpec = null;

        List<Predicate> predicates = new ArrayList<>();

        studentSpec = ((root, query, criteriaBuilder) -> {
            if (name != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }
            if (surname != null) {
                predicates.add(criteriaBuilder.equal(root.get("surname"), surname));
            }


            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        });

        return studentRepository.findAll(studentSpec);
    }

    @Override
    public List<Student> getStudents(String name, String surname, String age, String gender) {
        return studentRepository.getStudents(name, surname, age, gender);
    }

    @Override
    public List<Student> findAllStudents(List<SearchCriteria> searchCriteriaList) {
        StudentSpecification studentSpecification = new StudentSpecification();
        searchCriteriaList.forEach(studentSpecification::addSearchCriteria);
        return studentRepository.findAll(studentSpecification);
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> getAllStudentsPage(int pageSize , int pageNumber, String[] pageSort) {
        Pageable pageable=  PageRequest.of( pageSize,pageNumber, Sort.by(pageSort[0]).descending() );
        return studentRepository.findAll(pageable);
    }
}
