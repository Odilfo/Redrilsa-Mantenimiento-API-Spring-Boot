package com.bonifacio.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.IProyectoDao;
import com.bonifacio.app.entities.Proyecto;
import com.bonifacio.app.service.IProyectoService;


@Service
public class ProyectoServiceImpl implements IProyectoService{
	
	@Autowired
	private IProyectoDao proyectoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Proyecto> findAll() {
		return(List<Proyecto>)proyectoDao.findAll();
	}

	@Override
	public void saveProyecto(Proyecto proyecto) {
		proyectoDao.save(proyecto);
		
	}

	@Override
	public List<Proyecto> getProyectosUsuario(Long id) {
		return(List<Proyecto>)proyectoDao.findByProusuario(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Proyecto findById(Long proid) {
		return proyectoDao.findById(proid).orElse(null);
	}

	@Override
	public void deleteById(Long proid) {
		proyectoDao.deleteById(proid);
		
	}

	
}
