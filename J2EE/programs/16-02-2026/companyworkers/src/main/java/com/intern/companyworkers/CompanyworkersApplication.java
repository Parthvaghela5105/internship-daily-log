package com.intern.companyworkers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompanyworkersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyworkersApplication.class, args);
	}

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
