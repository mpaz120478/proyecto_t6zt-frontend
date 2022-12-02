package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Departamento;
import com.pe.repository.DepartamentoRepository;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public List<Departamento> listarDepartamentos() {
		return repository.findAll();
	}

}