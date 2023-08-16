package com.vcc.canastica.repositorios;

import com.vcc.canastica.modelos.Supermercado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSupermercado extends CrudRepository<Supermercado, Long> {

}
