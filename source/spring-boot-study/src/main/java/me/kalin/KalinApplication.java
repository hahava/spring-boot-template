package me.kalin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class KalinApplication {

	public static void main(String[] args) {
		SpringApplication.run(KalinApplication.class, args);
	}

}
