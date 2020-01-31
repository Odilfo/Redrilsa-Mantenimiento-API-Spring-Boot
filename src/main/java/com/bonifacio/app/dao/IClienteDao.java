package com.bonifacio.app.dao;


import org.springframework.data.repository.CrudRepository;

import com.bonifacio.app.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

	

}
