package com.sistema.tienda.backend.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sistema.tienda.backend.dto.CompraDTO;
import com.sistema.tienda.backend.dto.ItemCompraDTO;
import com.sistema.tienda.backend.model.Compra;
import com.sistema.tienda.backend.model.DetalleCompra;
import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.model.Producto;
import com.sistema.tienda.backend.model.Proveedor;
import com.sistema.tienda.backend.repository.CompraRepository;
import com.sistema.tienda.backend.repository.DetalleCompraRepository;
import com.sistema.tienda.backend.repository.InventarioRepository;
import com.sistema.tienda.backend.repository.ProductoRepository;
import com.sistema.tienda.backend.repository.ProveedorRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraServiceI{
	private final CompraRepository compraRepository;
    private final DetalleCompraRepository detalleCompraRepository;
    private final InventarioRepository inventarioRepository;
    private final ProveedorRepository proveedorRepository;
    private final ProductoRepository productoRepository;
  
    @Override
    @Transactional
    public Compra registrarCompra(CompraDTO compraDTO) {
    	
    	Proveedor proveedor = proveedorRepository.findById(compraDTO.getProveedorId())
    	        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    	
    	Compra compra = Compra.builder()
    	        .proveedor(proveedor)
    	        .total(BigDecimal.ZERO)
    	        .build();

    	compraRepository.save(compra);
    	
    	BigDecimal total = BigDecimal.ZERO;

    	for (ItemCompraDTO item : compraDTO.getItems()) {
    		Producto producto = productoRepository.findById(item.getProductoId())
    		        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    		BigDecimal subtotal = item.getPrecioUnitario()
    		        .multiply(BigDecimal.valueOf(item.getCantidad()));
    		DetalleCompra detalle = DetalleCompra.builder()
    		        .compra(compra)
    		        .producto(producto)
    		        .cantidad(item.getCantidad())
    		        .precioUnitario(item.getPrecioUnitario())
    		        .subtotal(subtotal)
    		        .build();

    		detalleCompraRepository.save(detalle);
    		Inventario inventario = inventarioRepository.findByProducto(producto)
    		        .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

    		Integer nuevaCantidad = inventario.getCantidad() + item.getCantidad();
    		inventario.setCantidad(nuevaCantidad);
    		total = total.add(subtotal);
    	}
    		
    	compra.setTotal(total);
    	compraRepository.save(compra);

    	return compra;
    	
    }
    
}
