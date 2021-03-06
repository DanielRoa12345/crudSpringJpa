package com.bolsaideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaideas.springboot.app.models.dao.IClienteDao;
import com.bolsaideas.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	//Inyectamos el cliente dao
	@Autowired
	private IClienteDao clienteDao;
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Cliente cliente) {
		 clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		
		return clienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.delete(id);
		
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		
		return clienteDao.findAll(pageable);
	}

}
