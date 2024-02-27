package az.ingress.msBankApp;

import az.ingress.msBankApp.repository.AccountRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class msBankAppApplication implements CommandLineRunner {
   private final AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(msBankAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        accountRepository.findAll().forEach(System.out::println);
//        accountRepository.findByAccountNumber("iba123").forEach(System.out::println);
        accountRepository.findAccountBy().forEach(System.out::println);
    }


}
