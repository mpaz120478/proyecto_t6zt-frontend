package com.pe.service;

import java.util.List;
import com.pe.entity.Cargo;

public interface CargoService {
	
	public abstract List<Cargo>listarCargos();
	public abstract Cargo insertaActualizaCargo(Cargo obj);
	public abstract void eliminaCargo(int idCargo);

}