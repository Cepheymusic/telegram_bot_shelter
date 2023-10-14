package dev.pro.shelter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShelterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShelterApplication.class, args);
	}

}
