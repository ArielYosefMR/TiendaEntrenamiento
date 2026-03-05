package com.sistema.tienda.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.tienda.backend.dto.ProveedorDTO;
import com.sistema.tienda.backend.model.Proveedor;
import com.sistema.tienda.backend.service.ProveedorServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorServiceI proveedorService;

    @PostMapping
    public Proveedor crearProveedor(@RequestBody ProveedorDTO proveedorDTO){
        return proveedorService.crearProveedor(proveedorDTO);
    }

    @GetMapping
    public List<Proveedor> listarProveedores(){
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor obtenerProveedor(@PathVariable Long id){
        return proveedorService.obtenerProveedorPorId(id);
    }

    @PutMapping("/{id}")
    public Proveedor actualizarProveedor(
            @PathVariable Long id,
            @RequestBody ProveedorDTO proveedorDTO){

        return proveedorService.actualizarProveedor(id, proveedorDTO);
    }

    @DeleteMapping("/{id}")
    public void desactivarProveedor(@PathVariable Long id){
        proveedorService.desactivarProveedor(id);
    }

}