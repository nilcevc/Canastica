package com.vcc.canastica.DTO;

import lombok.Data;

//DTO data tranfer object
@Data
public class ProductoXSupermercadoDTO {
    private Long codigoProducto;
    private Long idSuper;
    private double precio;
}
