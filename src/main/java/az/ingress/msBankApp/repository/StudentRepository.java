package az.ingress.msBankApp.repository;

import az.ingress.msBankApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    Optional<Student> findByName(String name);

    Student findBySurname(String surname);

    Student findByNameOrSurnameOrAgeOrGender(String name, String surname, String age, String gender);

    @Query("select s from Student s where ((:name is null or s.name =:name))" +
            "or (:surname is null or s.surname =:surname)" +
            "or (:age is null or s.age =:age)" +
            "or (:gender is null or s.gender =:gender) ")
    List<Student> getStudents(@Param("name") String name,
                              @Param("surname") String surname,
                              @Param("age") String age,
                              @Param("gender") String gender);

    Student findByNameAndAge(String name, String age);
}
