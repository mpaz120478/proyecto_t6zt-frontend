package com.pe.controller;

import java.util.Date;
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
import com.pe.entity.Cliente;
import com.pe.service.ClienteService;
import com.pe.util.AppSettings;
import com.pe.util.Constantes;

@RestController
@RequestMapping("/url/clientes")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> lista = clienteService.listarClientes();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaClientePorDatosLike/{datos}")
	@ResponseBody
	public ResponseEntity<List<Cliente>>listaClientePorDatosLike(@PathVariable("datos") String datosCliente) {
		List<Cliente> lista  = null;
		try {
			if (datosCliente.equals("todos")) {
				lista = clienteService.listaPorDatosLike("%");
			}else {
				lista = clienteService.listaPorDatosLike("%" + datosCliente + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdCliente(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Cliente objSalida =  clienteService.insertaActualizaCliente(obj);
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
	
	@PutMapping("/actualizaCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCliente(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objSalida =  clienteService.insertaActualizaCliente(obj);
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
	
	@DeleteMapping("/eliminaCliente/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCliente(@PathVariable("id") int idCliente) {
		Map<String, Object> salida = new HashMap<>();
		try {
			clienteService.eliminaCliente(idCliente);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
}