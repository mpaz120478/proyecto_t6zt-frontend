package com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pe.entity.Cargo;


public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	

}