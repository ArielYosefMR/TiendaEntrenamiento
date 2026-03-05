package com.sistema.tienda.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.tienda.backend.model.Venta;

public interface VentaRepository extends JpaRepository<Venta,Long>{

}
