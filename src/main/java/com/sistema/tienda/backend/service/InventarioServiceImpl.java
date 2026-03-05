package com.sistema.tienda.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioServiceI{
	
	InventarioRepository inventarioRepository;

	@Override
	public List<Inventario> obtenerProductosBajoStock() {
	    return inventarioRepository.findBajoStock();
	}

}
