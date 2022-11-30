package com.pe.service;

import java.util.List;
import com.pe.entity.Empleado;


public interface EmpleadoService {

	public abstract List<Empleado>listarEmpleados();
	public abstract Empleado insertaActualizaEmpleado(Empleado obj);
	public abstract void eliminaEmpleado(int IdEmpleado);
	public abstract List<Empleado>listaPorApellidosLike(String ApeEmpleado);
}