package com.vcc.canastica.controladores;

import com.vcc.canastica.modelos.Marca;
import com.vcc.canastica.repositorios.RepositorioMarca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("marca")
public class ControladorMarca {

    private final RepositorioMarca repoMarca;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repoMarca.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMarca(@PathVariable Long id){
        return ResponseEntity.ok(repoMarca.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> agregarMarca(@RequestBody Marca marca){
        return ResponseEntity.ok(repoMarca.save(marca));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarMarca(@PathVariable Long id){
        repoMarca.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
