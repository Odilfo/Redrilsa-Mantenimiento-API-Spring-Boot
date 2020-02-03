package com.bonifacio.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bonifacio.app.dao.IUsuarioDao;
import com.bonifacio.app.entities.Usuario;
import com.bonifacio.app.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {

		return(List<Usuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario checkUsuarioLogin(Usuario usuario) {
		return(Usuario)usuarioDao.findByEmailAndPassword(usuario.getEmail(),usuario.getPassword());
		
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		
		usuarioDao.save(usuario);
	}

	@Override
	public Usuario findUsuario(Usuario usuario) {
		return(Usuario)usuarioDao.findByEmail(usuario.getEmail());
		
	}

	@Override
	@Transactional
	public Usuario updateUsuario(Usuario usuario) {
		
		return(Usuario)usuarioDao.save(usuario);
	}
	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
		
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteUsuario(Long id) {

		usuarioDao.deleteById(id);
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		usuarioDao.deleteById(usuario.getId());
	}
	
/*Busqueda por SQL
*/
	@Override
	public Usuario findByIdSQL(Long id) {
		return usuarioDao.findByIdSQL(id);
		
	}
	
	
}