package com.sistema.tienda.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.tienda.backend.dto.VentaDTO;
import com.sistema.tienda.backend.model.Venta;
import com.sistema.tienda.backend.service.VentaServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaServiceI ventaService;

    @PostMapping
    public Venta registrarVenta(@RequestBody VentaDTO ventaDTO) {
        return ventaService.registrarVenta(ventaDTO);
    }
}