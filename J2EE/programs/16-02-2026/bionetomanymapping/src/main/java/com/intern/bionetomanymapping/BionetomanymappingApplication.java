package com.intern.bionetomanymapping;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BionetomanymappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BionetomanymappingApplication.class, args);
	}

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
