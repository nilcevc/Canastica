package com.vcc.canastica.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "productoXSupermercado")
@Getter @Setter
public class ProductoXSupermercado {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private double precio;
    private LocalDate fecha;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supermercado_id")
    private Supermercado supermercado;
}
