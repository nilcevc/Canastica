package com.vcc.canastica.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private String nombreMarca;

    private List<SupermercadosXProductoDTO> supermercadosXProductoDTOList;
}
