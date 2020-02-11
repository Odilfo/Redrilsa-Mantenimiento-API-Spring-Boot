package com.bonifacio.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonifacio.app.entities.Asignacion;
import com.bonifacio.app.service.IAsignacionService;

@RestController
@RequestMapping("/api")
public class AsignacionController {
	
	
	@Autowired
	private IAsignacionService asignacionService;
	
	@GetMapping("/asignaciones")
	public ResponseEntity<?>listaAsignaciones(){
		List<Asignacion>listaAsignaciones=asignacionService.findAll();
		if(listaAsignaciones!=null) {
			if(listaAsignaciones.size()!=0) {
				return new ResponseEntity<>(listaAsignaciones,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/asignaciones/{asigid}")
	public Asignacion obtener(@PathVariable Long asigid) {
		Asignacion asi=asignacionService.findById(asigid);
		return asi;
	}
	
	@PostMapping("/asignaciones")
	public ResponseEntity<?>addAsignaciones(@RequestBody Asignacion asignacion){
		asignacionService.saveAsignacion(asignacion);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/asignaciones/{asigid}")
	public ResponseEntity<Void>deleteAsignacion(@PathVariable(value="asigid")Long asigid){
		asignacionService.findById(asigid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
