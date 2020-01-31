package com.bonifacio.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bonifacio.app.entities.Usuario;
import com.bonifacio.app.mapper.Mapper;
import com.bonifacio.app.model.MUsuario;
import com.bonifacio.app.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario>getUsuarios(){
		return usuarioService.findAll();
		
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario obtener(@PathVariable(value="id")Long id){
		Usuario usu=usuarioService.findById(id);
		return usu;
				
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Void>addUsuario(@RequestBody Usuario usuario){
		if(usuarioService.findUsuario(usuario)==null) {
			usuarioService.save(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}

	@PostMapping("/login")
	public ResponseEntity<?>loginUsuario(@RequestBody Usuario usuario){
		Usuario usuDb=usuarioService.checkUsuarioLogin(usuario);
		if(usuDb!=null) {
			List<Usuario>usuarios=new ArrayList<>();
			usuarios.add(usuDb);
			List<MUsuario>mUsuarios=new ArrayList<>();
			mUsuarios=Mapper.convertirLista(usuarios);
			return new ResponseEntity<>(mUsuarios,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?>updateUsuario(@PathVariable(value="id")Long id,@RequestBody Usuario usuario){
		Usuario usuDb=null;
		usuDb=usuarioService.findById(id);
		if(usuDb!=null) {
			usuDb.setEmail(usuario.getEmail());
			usuDb.setCargo(usuario.getCargo());
			usuDb.setDni(usuario.getDni());
			usuDb.setFoto(usuario.getFoto());
			usuDb.setNombre(usuario.getNombre());
			usuarioService.updateUsuario(usuDb);
			
			return new ResponseEntity<>(usuDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update_sql")
	public ResponseEntity<?>updateUsuarioSql(@RequestBody Usuario usuario){
		Usuario usuDb=null;
		usuDb=usuarioService.findByIdSQL(usuario.getId());
		if(usuDb!=null) {
			usuDb.setEmail(usuario.getEmail());
			usuDb.setCargo(usuario.getCargo());
			usuDb.setDni(usuario.getDni());
			usuDb.setFoto(usuario.getFoto());
			usuDb.setNombre(usuario.getNombre());
			usuarioService.updateUsuario(usuDb);
			return new ResponseEntity<>(usuDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Void>deleteUsuario(@PathVariable(value="id")Long id){
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
