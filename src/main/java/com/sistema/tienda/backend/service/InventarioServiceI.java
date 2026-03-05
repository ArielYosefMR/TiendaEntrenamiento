package com.sistema.tienda.backend.service;

import java.util.List;

import com.sistema.tienda.backend.model.Inventario;

public interface InventarioServiceI {

	List<Inventario> obtenerProductosBajoStock();
}
