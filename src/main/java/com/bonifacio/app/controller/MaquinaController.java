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

import com.bonifacio.app.entities.Maquina;


import com.bonifacio.app.service.IMaquinaService;

@RestController
@RequestMapping("/api")
public class MaquinaController {
	
	@Autowired
	private IMaquinaService maquinaService;
	
	
	@GetMapping("/maquinas")
	public ResponseEntity<?>listaMaquinas(){
		List<Maquina>listaMaquinas=maquinaService.findAll();
		if(listaMaquinas!=null) {
			if(listaMaquinas.size()!=0) {
				return new ResponseEntity<>(listaMaquinas,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/maquinas/{id}")
	public Maquina obtener(@PathVariable Long id) {
		Maquina maq=maquinaService.findById(id);
		return maq;
	}
	
	
	@PostMapping("/maquinas")
	public ResponseEntity<?>addMaquina(@RequestBody Maquina maquina){
		maquinaService.saveMaquina(maquina);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/maquinas/{id}")
	 public ResponseEntity<Void>deleteMaquina(@PathVariable(value="id")Long id){
		maquinaService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	

}
