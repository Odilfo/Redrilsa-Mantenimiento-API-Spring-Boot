package com.bonifacio.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bonifacio.app.entities.Proyecto;

public interface IProyectoDao extends CrudRepository<Proyecto,Long> {
	
	public List<Proyecto>findByProusuario(Long id);

}
