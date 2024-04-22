package com.unicaes.lab02pubilpreza.service.dto;

import lombok.Data;

@Data
public class ProductoInDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private int stock;
}
