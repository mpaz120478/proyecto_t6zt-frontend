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
import com.pe.entity.Usuario;
import com.pe.service.UsuarioService;
import com.pe.util.AppSettings;
import com.pe.util.Constantes;

@RestController
@RequestMapping("/url/usuarios")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> lista = usuarioService.listarUsuarios();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaUsuarioPorApellidoLike/{ape}")
	@ResponseBody
	public ResponseEntity<List<Usuario>>listaPorApellidoLike(@PathVariable("ape") String ApeEmpleado) {
		List<Usuario> lista  = null;
		try {
			if (ApeEmpleado.equals("todos")) {
				lista = usuarioService.listaPorApellidoLike("%");
			}else {
				lista = usuarioService.listaPorApellidoLike("%" + ApeEmpleado + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaUsuario(@RequestBody Usuario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdUsuario(0);
			obj.setFechaRegistro(new Date());
			obj.setEstado(1);
			Usuario objSalida =  usuarioService.insertaActualizaUsuario(obj);
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
	
	@PutMapping("/actualizaUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaUsuario(@RequestBody Usuario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario objSalida =  usuarioService.insertaActualizaUsuario(obj);
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
	
	@DeleteMapping("/eliminaUsuario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaUsuario(@PathVariable("id") int IdUsuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			usuarioService.eliminaUsuario(IdUsuario);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}