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
import com.pe.util.Constantes;
import com.pe.entity.Cargo;
import com.pe.service.CargoService;
import com.pe.util.AppSettings;

@RestController
@RequestMapping("/url/cargos")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cargo>> listarCargos(){
		List<Cargo> lista = cargoService.listarCargos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraCargo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCargo(@RequestBody Cargo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdCargo(0);
			Cargo objSalida =  cargoService.insertaActualizaCargo(obj);
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
	
	@PutMapping("/actualizaCargo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCargo(@RequestBody Cargo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Cargo objSalida =  cargoService.insertaActualizaCargo(obj);
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
	
	@DeleteMapping("/eliminaCargo/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaAlumno(@PathVariable("id") int IdCargo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			cargoService.eliminaCargo(IdCargo);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}