package se.knowit.bookit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.knowit.bookit.model.User;
import se.knowit.bookit.repository.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class BookitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Ola", "Ali", "Albin", "Anders", "Susanne").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@knowit.se");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
