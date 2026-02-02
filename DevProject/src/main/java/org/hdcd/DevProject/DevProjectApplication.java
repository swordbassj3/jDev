package org.hdcd.DevProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DevProjectApplication {
	public static void main(String[] args) {
		System.out.print("Hello World");
		SpringApplication.run(DevProjectApplication.class, args);
	}
}
