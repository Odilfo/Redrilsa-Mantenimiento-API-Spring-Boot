package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Asignacion;

public interface IAsignacionService {
	
	public List<Asignacion>findAll();
	
	public void saveAsignacion(Asignacion asignacion);
	
	public Asignacion findById(Long asigid);
	
	public void deleteById(Long asigid);
	

}
