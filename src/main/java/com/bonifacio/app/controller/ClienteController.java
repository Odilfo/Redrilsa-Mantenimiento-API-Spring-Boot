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

import com.bonifacio.app.entities.Cliente;

import com.bonifacio.app.service.IClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public ResponseEntity<?>listaClientes(){
		List<Cliente>listaClientes=clienteService.findAll();
		if(listaClientes!=null) {
			if(listaClientes.size()!=0) {
				return new ResponseEntity<>(listaClientes,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/clientes/{clienid}")
	public Cliente obtener(@PathVariable(value="clienid")Long clienid) {
		Cliente cli=clienteService.findById(clienid);
		return cli;
	}
	
	
	@PostMapping("/clientes")
	public ResponseEntity<?>addClientes(@RequestBody Cliente cliente){
		clienteService.saveCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{clieid}")
	 public ResponseEntity<Void>deleteCliente(@PathVariable(value="clienid")Long clienid){
		clienteService.deleteById(clienid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
