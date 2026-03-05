package com.sistema.tienda.backend.service;

import java.util.List;
import com.sistema.tienda.backend.dto.ProveedorDTO;
import com.sistema.tienda.backend.model.Proveedor;

public interface ProveedorServiceI {

    Proveedor crearProveedor(ProveedorDTO proveedorDTO);

    List<Proveedor> listarProveedores();

    Proveedor obtenerProveedorPorId(Long id);

    Proveedor actualizarProveedor(Long id, ProveedorDTO proveedorDTO);

    void desactivarProveedor(Long id);

}