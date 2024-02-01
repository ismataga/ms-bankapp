package com.eduwise.eduwise;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
//(exclude = UserDetailsServiceAutoConfiguration.class
@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
//@EntityScan(basePackages = "com.eduwise.eduwise")
public class EduwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduwiseApplication.class, args);
	}

}
