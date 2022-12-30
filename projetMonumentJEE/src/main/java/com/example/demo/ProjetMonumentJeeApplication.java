package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.repositories.MonumentRepository;

@SpringBootApplication
public class ProjetMonumentJeeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjetMonumentJeeApplication.class, args);
		MonumentRepository monumentRepository = ctx.getBean(MonumentRepository.class);
		monumentRepository.findAll().forEach(m ->System.out.println(m.getNom()));
		
	}

}
