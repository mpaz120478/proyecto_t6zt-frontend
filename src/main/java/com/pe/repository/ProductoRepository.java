package com.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pe.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("select p from Producto p where p.nomProducto like ?1")
	public List<Producto> listaPorNombreLike(String nomProducto);

}
