package com.hkdev;

import com.hkdev.backend.persistence.domain.Customer;
import com.hkdev.backend.persistence.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(CustomerRepository repository) {
		return evt -> {
			repository.save(new Customer("Customer 1", "customer1@mail.com"));
			repository.save(new Customer("Customer 2", "customer2@mail.com"));
		};
	}
}
