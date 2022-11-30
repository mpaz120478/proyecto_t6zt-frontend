package com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pe.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}