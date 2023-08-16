package com.vcc.canastica.repositorios;

import com.vcc.canastica.modelos.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends CrudRepository<Producto, Long> {
}
