package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Cliente;
import com.pe.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listarClientes() {
		return repository.findAll();
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaCliente(int IdCliente) {
		repository.deleteById(IdCliente);
		
	}

	@Override
	public List<Cliente> listaPorDatosLike(String DatosCliente) {
		return repository.listaPorDatosLike(DatosCliente);
	}

}