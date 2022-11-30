package com.pe.service;

import java.util.List;
import com.pe.entity.Usuario;


public interface UsuarioService {

	public abstract List<Usuario> listarUsuarios();
	public abstract Usuario insertaActualizaUsuario(Usuario obj);
	public abstract void eliminaUsuario(int IdUsuario);
	public abstract List<Usuario>listaPorApellidoLike(String ApeEmpleado);
}