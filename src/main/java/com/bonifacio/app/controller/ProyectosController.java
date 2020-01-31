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

import com.bonifacio.app.entities.Proyecto;
import com.bonifacio.app.entities.Usuario;
import com.bonifacio.app.service.IProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectosController {
	
	@Autowired
	private IProyectoService proyectoService;
	
	@GetMapping("/proyectos")
	public ResponseEntity<?>listaProyectos(){
		List<Proyecto>listaProyectos=proyectoService.findAll();
		if(listaProyectos!=null) {
			if(listaProyectos.size()!=0) {
				return new ResponseEntity<>(listaProyectos,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/proyectos/{proid}")
	public Proyecto obtener(@PathVariable(value="proid")Long proid) {
		Proyecto pro=proyectoService.findById(proid);
		return pro;
	}
	
	
	@PostMapping("/proyectos")
	public ResponseEntity<?>addProyectos(@RequestBody Proyecto proyecto){
		proyectoService.saveProyecto(proyecto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PostMapping("/proyectos_usuario")
	public ResponseEntity<?>verProyectoUsuario(@RequestBody Usuario usuario){
		List<Proyecto>listaProyectos=proyectoService.getProyectosUsuario(usuario.getId());
		if(listaProyectos!=null) {
			if(listaProyectos.size()!=0) {
				return new ResponseEntity<>(listaProyectos,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping("/proyectos/{proid}")
	 public ResponseEntity<Void>deleteProyecto(@PathVariable(value="proid")Long proid){
		proyectoService.deleteById(proid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
