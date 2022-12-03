package com.pe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pe.entity.Producto;
import com.pe.service.ProductoService;
import com.pe.util.AppSettings;
import com.pe.util.Constantes;

@RestController
@RequestMapping("/url/productos")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listarProductos")
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductos(){
		List<Producto> lista = productoService.listarProductos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaPorNombreLike(@PathVariable("nom") String nomProducto) {
		List<Producto> lista  = null;
		try {
			if (nomProducto.equals("todos")) {
				lista = productoService.listaPorNombreLike("%");
			}else {
				lista = productoService.listaPorNombreLike("%" + nomProducto + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdProducto(0);
			
			Producto objSalida =  productoService.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida =  productoService.insertaActualizaProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
