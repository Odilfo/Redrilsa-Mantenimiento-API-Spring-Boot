package com.bonifacio.app.model;

import com.bonifacio.app.entities.Usuario;

public class MUsuario {
	
	private Long id;
	private String dni;
	private String nombre;
	private String cargo;
	private String email;
	private String password;
	
	
	public MUsuario(Usuario usuario) {
		this.id = usuario.getId();
		this.dni = usuario.getDni();
		this.nombre =usuario.getNombre();
		this.cargo = usuario.getCargo();
		this.email = usuario.getEmail();
		
	}
	
	

	public MUsuario(Long id, String dni, String nombre, String cargo, String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.cargo = cargo;
		this.email = email;
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
