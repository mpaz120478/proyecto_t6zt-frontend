package com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pe.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}