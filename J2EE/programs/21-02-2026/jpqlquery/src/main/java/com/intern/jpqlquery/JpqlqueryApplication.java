package com.intern.jpqlquery;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpqlqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpqlqueryApplication.class, args);
	}

    @Bean
    Faker faker(){
        return new Faker();
    }
}
