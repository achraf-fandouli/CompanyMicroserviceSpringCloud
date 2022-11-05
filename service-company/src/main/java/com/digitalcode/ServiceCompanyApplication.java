package com.digitalcode;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.digitalcode.dao.CompanyRepository;
import com.digitalcode.entities.Company;

@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CompanyRepository companyRepository) {
	    return args->{
	        Stream.of("A","B","C").forEach(cn->{
	            companyRepository.save(new Company(null,cn,100+Math.random()*900));
	        });
	        companyRepository.findAll().forEach(System.out::println);
	    };
	}

}
