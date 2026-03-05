package com.sistema.tienda.backend.service;

import com.sistema.tienda.backend.dto.CompraDTO;
import com.sistema.tienda.backend.model.Compra;

public interface CompraServiceI {
	
	public Compra registrarCompra(CompraDTO compraDTO);

}
