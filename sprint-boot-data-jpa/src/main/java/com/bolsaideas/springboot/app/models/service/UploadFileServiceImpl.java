package com.bolsaideas.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	//DEBUG LOGGER
	private final Logger log = LogManager.getLogger(getClass());

	private final static String UPLOADS_FOLDER = "uploads";


	@Override
	public Resource load(String filename) throws MalformedURLException {
		Path pathfoto = getPath(filename);
		log.info("PathFoto : "+pathfoto);
		Resource recurso= null;
		//Creamos el recuerdo 

		recurso =  new UrlResource(pathfoto.toUri());
		if (!recurso.exists() || !recurso.isReadable()) {
			throw new RuntimeException("Erro: no se puede cargar la imagen" + pathfoto.toString());
		}
		
		return recurso;
	}


	@Override
	public String copy(MultipartFile file) throws IOException {
		//Validar un unico archivo 
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

		Path rootPath = getPath(uniqueFilename);

		//Nombres de los directorios 
		log.info("rootPath:" + rootPath);


		//Usar el metodo copy  
		Files.copy(file.getInputStream(), rootPath);

		return uniqueFilename;
	}

	@Override
	public boolean delete(String filename) {

		Path rootPath = getPath(filename);
		File archivo = rootPath.toFile();

		//Que el archivo exista y que se pueda leer 
		if (archivo.exists() && archivo.canRead()) {
			if (archivo.delete()) {

				return true;
			}
		}

		return false;
	}

	public Path getPath(String filename) {
		return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
	}


	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
		
	}


	@Override
	public void init() throws IOException {
		// TODO Auto-generated method stub
		Files.createDirectories(Paths.get(UPLOADS_FOLDER));
		
	}

}
