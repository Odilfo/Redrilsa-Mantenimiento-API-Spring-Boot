package com.bonifacio.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.IClienteDao;
import com.bonifacio.app.entities.Cliente;
import com.bonifacio.app.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		
		return(List<Cliente>)clienteDao.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	public void deleteById(Long clienid) {
	
		clienteDao.deleteById(clienid);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long clienid) {
		return clienteDao.findById(clienid).orElse(null);
	}

}
