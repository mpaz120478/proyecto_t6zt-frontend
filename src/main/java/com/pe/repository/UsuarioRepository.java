package com.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pe.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.apeEmpleado like ?1")
	public List<Usuario> listaPorApellidoLike(String apeEmpleado);

}