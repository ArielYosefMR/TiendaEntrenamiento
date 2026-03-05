package com.sistema.tienda.backend.service;

import java.util.List;

import com.sistema.tienda.backend.dto.ProductoDTO;
import com.sistema.tienda.backend.model.Producto;

public interface ProductoServiceI {

    Producto registrarProducto(ProductoDTO productoDTO);
    List<Producto> listarProductos();
    Producto obtenerProductoPorId(Long id);
    Producto actualizarProducto(Long id, ProductoDTO productoDTO);
    void desactivarProducto(Long id);
    Producto obtenerPorCodigoBarras(String codigoBarras);

}