package fr.mns.java.mvcsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //exclude = { SecurityAutoConfiguration.class }
public class MvcSecurity3Application {

	public static void main(String[] args) {
		SpringApplication.run(MvcSecurity3Application.class, args);
	}

}
