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

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class msBankAppApplication implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(msBankAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        accountRepository.findAll().forEach(System.out::println);
//        accountRepository.findByAccountNumber("iba123").forEach(System.out::println);
//        accountRepository.findAccountBy().forEach(System.out::println);

        Student qulu = Student.builder()
                .name("Qulu")
                .surname("Memmedov")
                .age("20")
                .gender("M")
                .build();

        Student memmmed = Student.builder()
                .name("Memmed")
                .surname("Memmedov")
                .age("20")
                .gender("M")
                .build();

        Student esref = Student.builder()
                .name("Esref")
                .surname("Memmedov")
                .age("20")
                .gender("M")
                .build();
        List<Student> students = List.of(qulu, memmmed, esref);
        for (Student student : students) {
//            studentService.addStudent(student);
        }
        List<Student> allStudents = studentService.getAllStudents("Qulu", "Memedov");
//        allStudents.forEach(System.out::println);

        List<Student> students1 = studentService.getStudents(null, null, null, null);
        students1.forEach(System.out::println);
    }


}
