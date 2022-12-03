package com.pe.service;

import java.util.List;
import com.pe.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto>listarProductos();
	public abstract Producto insertaActualizaProducto(Producto obj);
	public abstract void eliminaProducto(int idProducto);
	public abstract List<Producto>listaPorNombreLike(String nomProducto);

}
