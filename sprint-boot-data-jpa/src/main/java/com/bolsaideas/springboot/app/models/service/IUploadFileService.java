package com.bolsaideas.springboot.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	//Cargar la imagen , carga un recuerso 
	public Resource load(String filename) throws MalformedURLException;
	
	//Return String el nombre unico de la imagen 
	public String copy (MultipartFile file)  throws IOException;
	
	public boolean delete(String filename);
	
	public void deleteAll();
	
	public void init() throws IOException;
}
