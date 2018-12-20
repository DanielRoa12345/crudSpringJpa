package com.bolsaideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsaideas.springboot.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public void guardar(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete (Long id );
	
	public Page<Cliente> findAll(Pageable pageable);
}
