package com.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pe.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("select c from Cliente c where c.datosCliente like ?1")
	public List<Cliente> listaPorDatosLike(String datosCliente);

}