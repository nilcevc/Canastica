package com.vcc.canastica.repositorios;

import com.vcc.canastica.modelos.ProductoXSupermercado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProductoXSupermercado extends CrudRepository<ProductoXSupermercado, Long> {

}
