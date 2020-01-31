package com.bonifacio.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String cargo;
	private String dni;
	@Column(length=60,unique=true)
	private String email;
	private String password;
	
	@Column(length=20000)
	private String foto;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="prousuario",referencedColumnName="id")
	private List<Proyecto>proyecto=new ArrayList<>();
	
	
	
	public List<Proyecto> getProyecto() {
		return proyecto;
	}
	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", cargo=" + cargo + ", email=" + email
				+ ", password=" + password + ", foto=" + foto + ", proyecto=" + proyecto + "]";
	}

}
