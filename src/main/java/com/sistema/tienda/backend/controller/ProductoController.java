package com.sistema.tienda.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sistema.tienda.backend.dto.ProductoDTO;
import com.sistema.tienda.backend.model.Producto;
import com.sistema.tienda.backend.service.ProductoServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoServiceI productoService;

    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.registrarProducto(productoDTO);
    }
    
    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id){
        return productoService.obtenerProductoPorId(id);
    }
    
    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoDTO productoDTO){

        return productoService.actualizarProducto(id, productoDTO);
    }
    
    @DeleteMapping("/{id}")
    public void desactivarProducto(@PathVariable Long id){
        productoService.desactivarProducto(id);
    }
    
    @GetMapping("/codigo/{codigoBarras}")
    public Producto obtenerPorCodigo(@PathVariable String codigoBarras){
        return productoService.obtenerPorCodigoBarras(codigoBarras);
    }
}