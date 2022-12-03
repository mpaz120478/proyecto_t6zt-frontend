package com.pe.service;

import java.util.List;
import com.pe.entity.Categoria;

public interface CategoriaService {

	public abstract List<Categoria>listarCategorias();
	public abstract Categoria insertaActualizaCategoria(Categoria obj);
	public abstract void eliminaCategoria(int idCategoria);
}