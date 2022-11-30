package com.pe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pe.entity.Empleado;
import com.pe.service.EmpleadoService;
import com.pe.util.AppSettings;
import com.pe.util.Constantes;


@RestController
@RequestMapping("/url/empleados")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		List<Empleado> lista = empleadoService.listarEmpleados();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaEmpleadoPorApellidoLike/{ape}")
	@ResponseBody
	public ResponseEntity<List<Empleado>>listaPorApellidosLike(@PathVariable("ape") String ApeEmpleado) {
		List<Empleado> lista  = null;
		try {
			if (ApeEmpleado.equals("todos")) {
				lista = empleadoService.listaPorApellidosLike("%");
			}else {
				lista = empleadoService.listaPorApellidosLike("%" + ApeEmpleado + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraEmpleado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEmpleado(@RequestBody Empleado obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdEmpleado(0);
			obj.setEstado(1);
			Empleado objSalida =  empleadoService.insertaActualizaEmpleado(obj);
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
	
	@PutMapping("/actualizaEmpleado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEmpleado(@RequestBody Empleado obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Empleado objSalida =  empleadoService.insertaActualizaEmpleado(obj);
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
	
	@DeleteMapping("/eliminaEmpleado/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEmpleado(@PathVariable("id") int IdEmpleado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			empleadoService.eliminaEmpleado(IdEmpleado);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}