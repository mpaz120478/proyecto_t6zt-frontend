package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Categoria;
import com.pe.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public List<Categoria> listarCategorias() {
		return repository.findAll();
	}

	@Override
	public Categoria insertaActualizaCategoria(Categoria obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaCategoria(int idCategoria) {
		repository.deleteById(idCategoria);
	}

}