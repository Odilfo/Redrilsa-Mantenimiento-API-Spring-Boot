package com.bonifacio.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.InformeDao;
import com.bonifacio.app.entities.Informe;
import com.bonifacio.app.service.InformeService;

@Service
public class InformeServiceImpl implements InformeService {

	@Autowired
	private InformeDao informeDao;

	@Override
	@Transactional(readOnly=true)
	public List<Informe> findAll() {
		
		return(List<Informe>)informeDao.findAll();
	}

	@Override
	public void saveInforme(Informe informe) {
		
		informeDao.save(informe);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Informe findById(Long infoid) {
		// TODO Auto-generated method stub
		return informeDao.findById(infoid).orElse(null);
	}

	@Override
	public void deleteInforme(Long infoid) {
		
		informeDao.deleteById(infoid);
		
	}
	
	
	
	
}
