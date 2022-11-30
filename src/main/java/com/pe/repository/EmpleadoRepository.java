package com.pe.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pe.entity.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	@Query("select e from Empleado e where e.ApeEmpleado like ?1")
	public List<Empleado> listaPorApellidosLike(String ApeEmpleado);

}