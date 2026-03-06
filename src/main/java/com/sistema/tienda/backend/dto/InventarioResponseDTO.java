package com.sistema.tienda.backend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventarioResponseDTO {

    private String producto;
    private Integer cantidad;
}