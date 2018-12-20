package com.bolsaideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsaideas.springboot.app.models.service.UploadFileServiceImpl;

@SpringBootApplication
public class SprintBootDataJpaApplication implements CommandLineRunner {

	@Autowired
	UploadFileServiceImpl uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SprintBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Crear un directorio 
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}
}
