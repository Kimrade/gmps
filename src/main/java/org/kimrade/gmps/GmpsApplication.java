package org.kimrade.gmps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GmpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmpsApplication.class, args);
	}

}
