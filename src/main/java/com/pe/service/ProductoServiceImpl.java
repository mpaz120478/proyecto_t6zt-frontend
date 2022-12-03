package com.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.entity.Producto;
import com.pe.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listarProductos() {
		return repository.findAll();
	}

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaProducto(int idProducto) {
		repository.deleteById(idProducto);
	}

	@Override
	public List<Producto> listaPorNombreLike(String nomProducto) {
		return repository.listaPorNombreLike(nomProducto);
	}

}
