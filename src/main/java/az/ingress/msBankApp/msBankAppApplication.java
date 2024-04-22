package az.ingress.msBankApp;

import az.ingress.msBankApp.entity.Student;
import az.ingress.msBankApp.repository.AccountRepository;
import az.ingress.msBankApp.repository.StudentRepository;
import az.ingress.msBankApp.service.StudentService;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
public class msBankAppApplication implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(msBankAppApplication.class, args);
    }

    @Transactional
    public void run(String... args) throws Exception {

       Student student =Student.builder().name("Ali").age("25").build();
       studentRepository.save(student);

//
//        Student student1= studentRepository.findById(1L).get();
//        System.out.println(student1);


//        student1.setAge("27");
//        studentRepository.save(student1);
//        Thread.sleep(5000);




    }


}
