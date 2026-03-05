package com.sistema.tienda.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.model.Producto;

public interface InventarioRepository extends JpaRepository<Inventario,Long>{

	Optional<Inventario> findByProducto(Producto producto);
	@Query("SELECT i FROM Inventario i WHERE i.cantidad <= i.stockMinimo")
	List<Inventario> findBajoStock();

}
