package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();

	public void saveCliente(Cliente cliente);
	
	public void deleteById(Long clienid);
	
	public Cliente findById(Long clienid);



}
