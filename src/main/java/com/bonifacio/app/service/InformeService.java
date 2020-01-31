package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Informe;

public interface InformeService {
	
	public List<Informe>findAll();
	
	public void saveInforme(Informe informe);
	
	public Informe findById(Long infoid);
	
	public void deleteInforme(Long infoid);

}
