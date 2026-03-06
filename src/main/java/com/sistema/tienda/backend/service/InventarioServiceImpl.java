package com.sistema.tienda.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.tienda.backend.dto.InventarioResponseDTO;
import com.sistema.tienda.backend.dto.InventarioUpdateDTO;
import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioServiceI{
	
	private final InventarioRepository inventarioRepository;

	@Override
	public List<Inventario> obtenerProductosBajoStock() {
	    return inventarioRepository.findBajoStock();
	}
	
	public Inventario actualizarInventario(Long productoId, InventarioUpdateDTO dto) {

	    Inventario inventario = inventarioRepository
	            .findByProductoId(productoId)
	            .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

	    inventario.setCantidad(dto.getCantidad());
	    inventario.setStockMinimo(dto.getStockMinimo());

	    return inventarioRepository.save(inventario);
	}
	
	public List<InventarioResponseDTO> obtenerInventario() {

	    List<Inventario> inventarios = inventarioRepository.findAll();

	    return inventarios.stream()
	            .map(inv -> InventarioResponseDTO.builder()
	                    .producto(inv.getProducto().getNombre())
	                    .cantidad(inv.getCantidad())
	                    .build())
	            .toList();
	}

}
