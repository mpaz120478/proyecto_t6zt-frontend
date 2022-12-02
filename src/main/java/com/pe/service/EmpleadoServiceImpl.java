package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Empleado;
import com.pe.repository.EmpleadoRepository;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;
	
	@Override
	public List<Empleado> listarEmpleados() {
		return repository.findAll();
	}

	@Override
	public Empleado insertaActualizaEmpleado(Empleado obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaEmpleado(int idEmpleado) {
		repository.deleteById(idEmpleado);
	}

	@Override
	public List<Empleado> listaPorApellidosLike(String apeEmpleado) {
		return repository.listaPorApellidosLike(apeEmpleado);
	}
	
}