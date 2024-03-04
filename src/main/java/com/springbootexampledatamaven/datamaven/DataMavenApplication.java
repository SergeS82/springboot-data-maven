package com.springbootexampledatamaven.datamaven;

import com.springbootexampledatamaven.datamaven.entity.User;
import com.springbootexampledatamaven.datamaven.repository.RepoUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DataMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMavenApplication.class, args);
	}

	@Bean
	CommandLineRunner demoJPA(RepoUser repository) {
		return (args) -> {
			repository.save(new User("Ivan","Ivanov"));
			repository.save(new User("Petr", "Petrov"));
			repository.save(new User("Sidr", "Sidorov"));
			repository.softDelete(1L);
			for (User user: repository.findAll()) {
				System.out.println(user);
			}
		};
	}

}
