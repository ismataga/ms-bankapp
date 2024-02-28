package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.repository.StudentRepository;
import az.ingress.msBankApp.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
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
    @Override
    public List<Student> getAllStudents(String name, String surname) {
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
}
