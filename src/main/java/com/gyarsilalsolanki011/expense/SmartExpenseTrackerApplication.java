package com.gyarsilalsolanki011.expense;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartExpenseTrackerApplication {

	public static void main(String[] args) {
		// Load custom .env file
		Dotenv dotenv = Dotenv.configure()
				.filename(".env")
				.load();

		// Set them as system properties
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
		System.setProperty("JWT_EXPIRATION_MS", dotenv.get("JWT_EXPIRATION_MS"));
		SpringApplication.run(SmartExpenseTrackerApplication.class, args);
	}
}
