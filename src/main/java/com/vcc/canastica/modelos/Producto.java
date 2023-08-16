package com.vcc.canastica.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "productos")
@Getter @Setter
public class Producto {
    @Id
    private Long codigo;

    private String nombre;
    private String descripcion;

    @ManyToOne
    private Marca marca;

    @OneToMany(mappedBy = "producto")
    private List<ProductoXSupermercado> supermercados;
}
