package com.rbac_Backend;

import com.rbac_Backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RbacBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacBackendApplication.class, args);
	}

//	@Bean
//	CommandLineRunner initAdmin(UserService userService) {
//		return args -> {
//			userService.createAdmin(
//					"admin",
//					"admin@rbac.com",
//					"admin123"
//			);
//		};
//	}

}
