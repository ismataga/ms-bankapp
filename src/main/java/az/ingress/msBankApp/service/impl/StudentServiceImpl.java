package az.ingress.msBankApp.service.impl;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.exception.AppException;
import az.ingress.msBankApp.model.SearchCriteria;
import az.ingress.msBankApp.repository.StudentRepository;
import az.ingress.msBankApp.service.StudentService;
import az.ingress.msBankApp.spec.StudentSpecification;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static az.ingress.msBankApp.exception.ExceptionConstants.STUDENT_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CacheManager cacheManager;
    private final RedisTemplate<String, Object> redisTemplate;

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
    public Page<Student> getAllStudentsPage(int pageSize, int pageNumber, String[] pageSort) {
        Pageable pageable = PageRequest.of(pageSize, pageNumber, Sort.by(pageSort[0]).descending());
        return studentRepository.findAll(pageable);
    }

    @Override
    @Cacheable(cacheNames = "student", key = "#id")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new AppException(STUDENT_NOT_FOUND));
    }

    @Override
    @Transactional
    @CachePut(cacheNames = "student", key = "#id")
    public Student updateStudent(Student student, Long id) {
        Student student1 = null;
        if (studentRepository.findById(id).isPresent()) {
            student1 = studentRepository.findById(id).get();
            student1.setName(student.getName());
            student1.setSurname(student.getSurname());
            student1.setAge(student.getAge());
            student1.setGender(student.getGender());
        }
        return student1;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "student", key = "#id")
    public Student deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new AppException(STUDENT_NOT_FOUND));
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student getStudentByName(String name) {
        Cache cache = cacheManager.getCache("student");
        Student cacheStudent = cache.get(name, Student.class);

        if (cacheStudent == null) {
            Student student = studentRepository.findByName(name).orElseThrow(() -> new AppException(STUDENT_NOT_FOUND));
            cache.put(student.getName(), student);
            return student;
        }
        return cacheStudent;
    }

//    @Override
//    public Student getStudentByName(String name) {
//        Student student = studentRepository.findByName(name).orElseThrow(() -> new AppException(STUDENT_NOT_FOUND));
//
//        redisTemplate.opsForValue().set(name, student);
//        return student;
//    }
}
