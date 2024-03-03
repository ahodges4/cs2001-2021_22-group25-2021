package com.example.Food4Everyone;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;






@SpringBootApplication
@EnableJpaAuditing
public class Food4EveryoneApplication {
	
	
	public static void main(String[] args){
		SpringApplication.run(Food4EveryoneApplication.class, args);
		
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

			}


