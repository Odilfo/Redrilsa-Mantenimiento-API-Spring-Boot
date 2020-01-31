package com.bonifacio.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="informes")
public class Informe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long infoid;
	private String sistema;
	private String 	descripcion;
	private String motivo;
	private String ot;
	private String horometro;
	private String evento;
	private String fecha;
	private String observacion;
	private Long asignacion_id;
	

	public Informe() {
		
	}
	
	public Long getInfoid() {
		return infoid;
	}
	public void setInfoid(Long infoid) {
		this.infoid = infoid;
	}
	

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getOt() {
		return ot;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public String getHorometro() {
		return horometro;
	}
	public void setHorometro(String horometro) {
		this.horometro = horometro;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getAsignacion_id() {
		return asignacion_id;
	}

	public void setAsignacion_id(Long asignacion_id) {
		this.asignacion_id = asignacion_id;
	}

	@Override
	public String toString() {
		return "Informe [infoid=" + infoid + ", sistema=" + sistema + ", descripcion=" + descripcion + ", motivo="
				+ motivo + ", ot=" + ot + ", horometro=" + horometro + ", evento=" + evento + ", fecha=" + fecha
				+ ", observacion=" + observacion + ", asignacion_id=" + asignacion_id + "]";
	}
	
	
	
}
