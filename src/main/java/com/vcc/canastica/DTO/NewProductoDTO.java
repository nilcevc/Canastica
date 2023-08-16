package com.vcc.canastica.DTO;

import com.vcc.canastica.modelos.Marca;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class NewProductoDTO {
    private long codigo;
    private String nombre;
    private String descripcion;

    private long idMarca;
}
