package com.sistema.tienda.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sistema.tienda.backend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	Iterable<Producto> findByEstadoTrue();
	Iterable<Producto> findByEstadoFalse();

}
