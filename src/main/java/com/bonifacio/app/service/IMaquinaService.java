package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Maquina;


public interface IMaquinaService {
	
	public List<Maquina>findAll();
	
	public void saveMaquina(Maquina maquina);
	
	public void deleteById(Long id);
	
	public Maquina findById(Long id);
	

}
