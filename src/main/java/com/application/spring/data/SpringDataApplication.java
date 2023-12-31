package com.application.spring.data;

import com.application.spring.data.domain.User;
import com.application.spring.data.domain.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Bean
	public ApplicationRunner configure(UserRepository userRepository) {
		return env -> {
			User user1 = new User("Beth", LocalDate.of(2023, Month.OCTOBER, 4 ));
			User user2 = new User("John", LocalDate.of(2023, Month.OCTOBER, 4 ));

			userRepository.save(user1);
			userRepository.save(user2);

			userRepository.findAll().forEach(System.out::println);
		};
	}

}
