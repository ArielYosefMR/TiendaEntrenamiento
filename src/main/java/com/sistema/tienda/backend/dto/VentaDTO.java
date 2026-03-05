package com.sistema.tienda.backend.dto;

import java.util.List;
import lombok.Data;

@Data
public class VentaDTO {

    private List<ItemVentaDTO> items;

}