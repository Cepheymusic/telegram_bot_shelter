package dev.pro.shelter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@OpenAPIDefinition
@SpringBootApplication
@EnableScheduling
public class ShelterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShelterApplication.class, args);
	}

}
