package com.sistema.tienda.backend.dto;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCompraDTO {

    private Long productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}