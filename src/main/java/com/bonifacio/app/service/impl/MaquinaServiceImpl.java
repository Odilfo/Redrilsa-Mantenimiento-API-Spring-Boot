package com.bonifacio.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.IMaquinaDao;
import com.bonifacio.app.entities.Maquina;
import com.bonifacio.app.service.IMaquinaService;

@Service
public class MaquinaServiceImpl implements IMaquinaService{
	
	@Autowired
	private IMaquinaDao maquinaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Maquina> findAll() {

		return(List<Maquina>)maquinaDao.findAll();
	}

	@Override
	public void saveMaquina(Maquina maquina) {
		
		maquinaDao.save(maquina);
	}

	@Override
	public void deleteById(Long maqid) {
		maquinaDao.deleteById(maqid);
	}

	@Override
	@Transactional(readOnly=true)
	public Maquina findById(Long maqid) {
		
		return maquinaDao.findById(maqid).orElse(null);
	}

}
