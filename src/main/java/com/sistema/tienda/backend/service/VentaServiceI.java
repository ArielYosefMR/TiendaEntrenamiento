package com.sistema.tienda.backend.service;

import com.sistema.tienda.backend.dto.VentaDTO;
import com.sistema.tienda.backend.model.Venta;

public interface VentaServiceI {

	Venta registrarVenta(VentaDTO ventaDTO);

}
