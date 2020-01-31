package com.bonifacio.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bonifacio.app.entities.Usuario;
import com.bonifacio.app.model.MUsuario;

@Component("mapper")
public class Mapper {
	
	public static List<MUsuario>convertirLista(List<Usuario>usuarios){
		List<MUsuario>mUsuarios=new ArrayList<>();
		for(Usuario usuario:usuarios) {
			mUsuarios.add(new MUsuario(usuario));
		}
		return mUsuarios;
	}
	
		
}
