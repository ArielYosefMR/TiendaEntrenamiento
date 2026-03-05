package com.sistema.tienda.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.tienda.backend.dto.CompraDTO;
import com.sistema.tienda.backend.model.Compra;
import com.sistema.tienda.backend.service.CompraServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {

	 private final CompraServiceI compraService;

	    @PostMapping
	    public Compra registrar(@RequestBody CompraDTO compraDTO) {
	        return compraService.registrarCompra(compraDTO);
	    }
}
