package com.sistema.tienda.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.tienda.backend.dto.InventarioResponseDTO;
import com.sistema.tienda.backend.dto.InventarioUpdateDTO;
import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.service.InventarioServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {
	
	private final InventarioServiceImpl inventarioService;

	@GetMapping("/bajo-stock")
	public ResponseEntity<List<Inventario>> obtenerBajoStock() {
	    return ResponseEntity.ok(inventarioService.obtenerProductosBajoStock());
	}
	
	@PutMapping("/set-bajo-stock/{productoId}")
	public ResponseEntity<Inventario> actualizarInventario(
	        @PathVariable Long productoId,
	        @RequestBody InventarioUpdateDTO dto) {

	    return ResponseEntity.ok(
	        inventarioService.actualizarInventario(productoId, dto)
	    );
	}

	@GetMapping
	public ResponseEntity<List<InventarioResponseDTO>> obtenerInventario() {
	    return ResponseEntity.ok(inventarioService.obtenerInventario());
	}
	
}
