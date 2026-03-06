package com.sistema.tienda.backend.dto;

import lombok.Data;

@Data
public class InventarioUpdateDTO {

    private Integer cantidad;
    private Integer stockMinimo;

}