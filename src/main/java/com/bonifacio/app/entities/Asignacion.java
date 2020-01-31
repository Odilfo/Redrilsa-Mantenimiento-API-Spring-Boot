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
@Table(name="asignaciones")
public class Asignacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fecha_asignacion;
	private Long maquina_id;
	private Long proyecto_id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="asignacion_id",referencedColumnName="id")
	private List<Informe>informe=new ArrayList<>();
	

	public List<Informe> getInforme() {
		return informe;
	}
	public void setInforme(List<Informe> informe) {
		this.informe = informe;
	}
	
	
	
	public Asignacion() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(String fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}
	public Long getMaquina_id() {
		return maquina_id;
	}
	public void setMaquina_id(Long maquina_id) {
		this.maquina_id = maquina_id;
	}
	public Long getProyecto_id() {
		return proyecto_id;
	}
	public void setProyecto_id(Long proyecto_id) {
		this.proyecto_id = proyecto_id;
	}
	


}
