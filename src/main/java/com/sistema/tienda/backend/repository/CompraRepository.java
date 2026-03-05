package com.sistema.tienda.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.tienda.backend.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{

}