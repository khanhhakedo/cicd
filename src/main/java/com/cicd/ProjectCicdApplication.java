package com.cicd;

import com.cicd.entity.Role;
import com.cicd.entity.User;
import com.cicd.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectCicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCicdApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(IUserService iUserService){
		return args -> {
			iUserService.saveRole(new Role(null, "ROLE_USER"));
			iUserService.saveRole(new Role(null, "ROLE_MANAGER"));
			iUserService.saveRole(new Role(null, "ROLE_ADMIN"));
			iUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			iUserService.saveUser(new User(null,"Khanhhakedo", "Khanh","123456","khanhhakedo@gmail.com", new HashSet<>()));
			iUserService.saveUser(new User(null,"Hung", "Hung1","123456","hung@gmail.com", new HashSet<>()));

			iUserService.addToUser("khanhhakedo@gmail.com","ROLE_USER");
			iUserService.addToUser("khanhhakedo@gmail.com","ROLE_MANAGER");

			iUserService.addToUser("hung@gmail.com","ROLE_ADMIN");
			iUserService.addToUser("hung@gmail.com","ROLE_SUPER_ADMIN");
		};
	}

}
