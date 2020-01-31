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
@Table(name="proyectos")
public class Proyecto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proid;
	private String nombre;
	private String distrito;
	private String provincia;
	private String departamento;
	private String fecha_inicio;
	private String fecha_fin;
	private Long prousuario;
	private Long procliente;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="proyecto_id",referencedColumnName="proid")
	private List<Asignacion>asignacion=new ArrayList<>();

	public Long getProid() {
		return proid;
	}

	public void setProid(Long proid) {
		this.proid = proid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Long getProusuario() {
		return prousuario;
	}

	public void setProusuario(Long prousuario) {
		this.prousuario = prousuario;
	}

	public List<Asignacion> getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(List<Asignacion> asignacion) {
		this.asignacion = asignacion;
	}

	public Long getProcliente() {
		return procliente;
	}

	public void setProcliente(Long procliente) {
		this.procliente = procliente;
	}

	@Override
	public String toString() {
		return "Proyecto [proid=" + proid + ", nombre=" + nombre + ", distrito=" + distrito + ", provincia=" + provincia
				+ ", departamento=" + departamento + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin
				+ ", prousuario=" + prousuario + ", procliente=" + procliente + ", asignacion=" + asignacion + "]";
	}
	
	

}
