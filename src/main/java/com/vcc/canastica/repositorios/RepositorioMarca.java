package com.vcc.canastica.repositorios;

import com.vcc.canastica.modelos.Marca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMarca extends CrudRepository<Marca, Long> {
}
