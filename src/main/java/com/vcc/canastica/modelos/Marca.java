package com.vcc.canastica.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "marcas")
@Getter @Setter
public class Marca {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String nombre;
}
