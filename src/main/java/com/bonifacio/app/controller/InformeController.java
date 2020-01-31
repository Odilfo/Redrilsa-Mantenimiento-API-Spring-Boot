package com.bonifacio.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bonifacio.app.entities.Informe;
import com.bonifacio.app.service.InformeService;

@RestController
@RequestMapping("/api")
public class InformeController {

	@Autowired
	private InformeService informeService;
	
	@GetMapping("/informes")
	public ResponseEntity<?>listaInformes(){
		List<Informe>listaInformes=informeService.findAll();
		if(listaInformes!=null) {
			if(listaInformes.size()!=0) {
				return new ResponseEntity<>(listaInformes,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	@GetMapping("/informes/{infoid}")
	public Informe obtener(@PathVariable(value="infoid")Long infoid) {
		Informe info=informeService.findById(infoid);
		return info;
	}
	
	@PostMapping("/informes")
	public ResponseEntity<Void>addInforme(@RequestBody Informe informe){
		informeService.saveInforme(informe);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
}
