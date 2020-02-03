package com.gabia.project.internproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "localDateTimeProvider")
public class InternProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternProjectApplication.class, args);
	}

}
