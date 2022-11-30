package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Cargo;
import com.pe.repository.CargoRepository;


@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository repository;
	
	@Override
	public List<Cargo> listarCargos() {
		return repository.findAll();
	}

	@Override
	public Cargo insertaActualizaCargo(Cargo obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaCargo(int IdCargo) {
		repository.deleteById(IdCargo);
	}
}