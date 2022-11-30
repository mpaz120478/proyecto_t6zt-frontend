package com.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pe.entity.Roles;
import com.pe.repository.RolesRepository;


@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository repository;
	
	@Override
	public List<Roles> listarRoles() {
		return repository.findAll();
	}
}