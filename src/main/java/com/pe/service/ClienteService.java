package com.pe.service;

import java.util.List;
import com.pe.entity.Cliente;

public interface ClienteService {

	public abstract List<Cliente>listarClientes();
	public abstract Cliente insertaActualizaCliente(Cliente obj);
	public abstract void eliminaCliente(int IdCliente);
	public abstract List<Cliente>listaPorDatosLike(String DatosCliente);
}