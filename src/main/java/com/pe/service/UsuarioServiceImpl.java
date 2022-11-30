package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Usuario;
import com.pe.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaUsuario(int IdUsuario) {
		repository.deleteById(IdUsuario);
	}

	@Override
	public List<Usuario> listaPorApellidoLike(String ApeEmpleado) {
		return repository.listaPorApellidoLike(ApeEmpleado);
	}


}