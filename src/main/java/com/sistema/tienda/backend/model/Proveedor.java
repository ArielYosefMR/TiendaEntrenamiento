package com.sistema.tienda.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String telefono;

    private String direccion;

    @Column(nullable = false)
    private Boolean estado = true;
}