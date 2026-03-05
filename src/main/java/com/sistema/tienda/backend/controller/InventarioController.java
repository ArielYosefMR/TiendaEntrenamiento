package com.sistema.tienda.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.service.InventarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {
	
	InventarioServiceImpl inventarioService;

	@GetMapping("/bajo-stock")
	public ResponseEntity<List<Inventario>> obtenerBajoStock() {
	    return ResponseEntity.ok(inventarioService.obtenerProductosBajoStock());
	}
	
}
