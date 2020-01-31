package com.bonifacio.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.IAsignacionDao;
import com.bonifacio.app.entities.Asignacion;
import com.bonifacio.app.service.IAsignacionService;

@Service
public class AsignacionServiceImpl implements IAsignacionService{
	
	@Autowired
	private IAsignacionDao asignacionDao;

	@Override
	@Transactional(readOnly=true)
	public List<Asignacion> findAll() {
		
		return(List<Asignacion>)asignacionDao.findAll();
	}

	@Override
	public void saveAsignacion(Asignacion asignacion) {
		
		asignacionDao.save(asignacion);
	}

	@Override
	@Transactional(readOnly=true)
	public Asignacion findById(Long asigid) {
	
		return asignacionDao.findById(asigid).orElse(null);
		
	}

	@Override
	public void deleteById(Long asigid) {
		
		asignacionDao.deleteById(asigid);		
	}

}
