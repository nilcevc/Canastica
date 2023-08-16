package com.vcc.canastica.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "supermercados")
@Getter @Setter
public class Supermercado {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String nombre;
    private String ubicacion;

    @OneToMany(mappedBy = "supermercado")
    private List<ProductoXSupermercado> productos;
}
