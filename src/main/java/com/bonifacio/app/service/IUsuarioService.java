package com.bonifacio.app.service;

import java.util.List;

import com.bonifacio.app.entities.Usuario;


public interface IUsuarioService {
	
	public List<Usuario>findAll();
	
	public Usuario checkUsuarioLogin(Usuario usuario);
	
	public void save(Usuario usuario);
	
	public Usuario findUsuario(Usuario usuario);
	
	public Usuario updateUsuario(Usuario usuario);
	
	public void deleteUsuario(Long id);
	
	public Usuario findById(Long id);
	
	public Usuario findByIdSQL(Long id);
	
	
	public void deleteUsuario(Usuario usuario);
	

}
