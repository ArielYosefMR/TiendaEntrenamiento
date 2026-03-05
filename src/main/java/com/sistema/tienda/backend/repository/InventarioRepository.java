package com.sistema.tienda.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.model.Producto;

public interface InventarioRepository extends JpaRepository<Inventario,Long>{

	Optional<Inventario> findByProducto(Producto producto);

}
