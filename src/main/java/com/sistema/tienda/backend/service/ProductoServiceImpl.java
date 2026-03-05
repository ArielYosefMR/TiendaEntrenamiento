package com.sistema.tienda.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.tienda.backend.dto.ProductoDTO;
import com.sistema.tienda.backend.model.Inventario;
import com.sistema.tienda.backend.model.Producto;
import com.sistema.tienda.backend.repository.InventarioRepository;
import com.sistema.tienda.backend.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoServiceI {

    private final ProductoRepository productoRepository;
    private final InventarioRepository inventarioRepository;

    @Override
    public Producto registrarProducto(ProductoDTO productoDTO) {

        Producto producto = Producto.builder()
                .codigoBarras(productoDTO.getCodigoBarras())
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .precioCompra(productoDTO.getPrecioCompra())
                .precioVenta(productoDTO.getPrecioVenta())
                .estado(true)
                .build();

        Producto productoGuardado = productoRepository.save(producto);

        Inventario inventario = Inventario.builder()
                .producto(productoGuardado)
                .cantidad(0)
                .build();

        inventarioRepository.save(inventario);

        return productoGuardado;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
    
    @Override
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long id, ProductoDTO productoDTO) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setCodigoBarras(productoDTO.getCodigoBarras());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioCompra(productoDTO.getPrecioCompra());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());

        return productoRepository.save(producto);
    }
    
    @Override
    public void desactivarProducto(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setEstado(false);

        productoRepository.save(producto);
    }

    @Override
    public Producto obtenerPorCodigoBarras(String codigoBarras) {

        return productoRepository.findByCodigoBarras(codigoBarras)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}