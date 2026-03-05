package com.sistema.tienda.backend.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductoDTO {

    private String codigoBarras;
    private String nombre;
    private String descripcion;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
}