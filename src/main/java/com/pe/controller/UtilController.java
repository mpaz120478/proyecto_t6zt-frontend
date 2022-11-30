package com.pe.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pe.entity.Cargo;
import com.pe.entity.Cliente;
import com.pe.entity.Departamento;
import com.pe.entity.Empleado;
import com.pe.entity.Roles;
import com.pe.entity.Usuario;
import com.pe.service.CargoService;
import com.pe.service.ClienteService;
import com.pe.service.DepartamentoService;
import com.pe.service.EmpleadoService;
import com.pe.service.RolesService;
import com.pe.service.UsuarioService;
import com.pe.util.AppSettings;


@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private DepartamentoService dptoService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private RolesService rolesService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listarDptos")
	@ResponseBody
	public List<Departamento> listarDepartamentos() {
		return dptoService.listarDptos();
	}
	
	@GetMapping("/listarCargos")
	@ResponseBody
	public List<Cargo> listarCargos() {
		return cargoService.listarCargos();
	}
	
	@GetMapping("/listarClientes")
	@ResponseBody
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
	}
	
	@GetMapping("/listarEmpleados")
	@ResponseBody
	public List<Empleado> listarEmpleados() {
		return empleadoService.listarEmpleados();
	}
	
	@GetMapping("/listarRoles")
	@ResponseBody
	public List<Roles> listarRoles() {
		return rolesService.listarRoles();
	}
	
	@GetMapping("/listarUsuarios")
	@ResponseBody
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
}