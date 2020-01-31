package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Proyecto;

public interface IProyectoService {
	
	public List<Proyecto>findAll();
	
	public void saveProyecto(Proyecto proyecto);
	
	public List<Proyecto>getProyectosUsuario(Long id);
	
	public Proyecto findById(Long proid);
	
	public void deleteById(Long proid);
	


}
