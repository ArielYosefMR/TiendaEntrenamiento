package com.sistema.tienda.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.tienda.backend.dto.ProveedorDTO;
import com.sistema.tienda.backend.model.Proveedor;
import com.sistema.tienda.backend.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorServiceI {

    private final ProveedorRepository proveedorRepository;

    @Override
    public Proveedor crearProveedor(ProveedorDTO proveedorDTO) {

        Proveedor proveedor = Proveedor.builder()
                .nombre(proveedorDTO.getNombre())
                .telefono(proveedorDTO.getTelefono())
                .direccion(proveedorDTO.getDireccion())
                .estado(true)
                .build();

        return proveedorRepository.save(proveedor);
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public Proveedor actualizarProveedor(Long id, ProveedorDTO proveedorDTO) {

        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setDireccion(proveedorDTO.getDireccion());

        return proveedorRepository.save(proveedor);
    }

    @Override
    public void desactivarProveedor(Long id) {

        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setEstado(false);

        proveedorRepository.save(proveedor);
    }
}