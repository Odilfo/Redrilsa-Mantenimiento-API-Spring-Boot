package com.bonifacio.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clienid;
	private String nombre;
	private String gerente;
	private String telefono;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="procliente",referencedColumnName="clienid")
	private List<Proyecto>proyecto=new ArrayList<>();
	
	
	public List<Proyecto> getProyecto() {
		return proyecto;
	}

	public void setProyecto(List<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}

	public Cliente() {
		
	}

	public Long getClienid() {
		return clienid;
	}

	public void setClienid(Long clienid) {
		this.clienid = clienid;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [clienid=" + clienid + ", nombre=" + nombre + ", gerente=" + gerente + ", telefono=" + telefono
				+ ", proyecto=" + proyecto + "]";
	}
	
	
	
	
}
