package com.sistema.tienda.backend.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private Long proveedorId;
    private List<ItemCompraDTO> items;
}