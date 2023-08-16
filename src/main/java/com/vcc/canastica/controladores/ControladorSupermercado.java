package com.vcc.canastica.controladores;

import com.vcc.canastica.DTO.ProductoXSupermercadoDTO;
import com.vcc.canastica.modelos.Producto;
import com.vcc.canastica.modelos.ProductoXSupermercado;
import com.vcc.canastica.modelos.Supermercado;
import com.vcc.canastica.repositorios.RepositorioProducto;
import com.vcc.canastica.repositorios.RepositorioProductoXSupermercado;
import com.vcc.canastica.repositorios.RepositorioSupermercado;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("supermercado")
public class ControladorSupermercado {
    private final RepositorioSupermercado repoSupermercado;
    private final RepositorioProductoXSupermercado repoProductoSuper;
    private final RepositorioProducto repoProducto;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repoSupermercado.findAll());
    }

    //Ruta GET
    @GetMapping("{id}")
    public ResponseEntity<?> getSupermercado(@PathVariable Long id){
        return ResponseEntity.ok(repoSupermercado.findById(id));
    }

    //Crear POST
    @PostMapping
    public ResponseEntity<?> agregarSupermercado(@RequestBody Supermercado supermercado){
        return ResponseEntity.ok(repoSupermercado.save(supermercado));
    }

    //Eliminar DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarSupermercado(@PathVariable Long id){

        Supermercado mercado = repoSupermercado.findById(id).get();

        repoProductoSuper.deleteAll(mercado.getProductos());
        repoSupermercado.delete(mercado);

        return ResponseEntity.ok().build();
    }

    //Asignar producto a supermercado POST
    @PostMapping("asignar")
    public ResponseEntity<?> asignarProducto(@RequestBody ProductoXSupermercadoDTO productoXSupermercadoDTO){
        ProductoXSupermercado productoXSupermercado = new ProductoXSupermercado();
        Supermercado supermercado = repoSupermercado.findById(productoXSupermercadoDTO.getIdSuper()).orElse(null);
        Producto producto = repoProducto.findById(productoXSupermercadoDTO.getCodigoProducto()).orElse(null);

        if (supermercado == null || producto == null){
            return ResponseEntity.notFound().build();
        }

        productoXSupermercado.setFecha(LocalDate.now());
        productoXSupermercado.setPrecio(productoXSupermercadoDTO.getPrecio());
        productoXSupermercado.setSupermercado(supermercado);
        productoXSupermercado.setProducto(producto);
        supermercado.getProductos().add(productoXSupermercado);
        repoProductoSuper.save(productoXSupermercado);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("{id}")
//    public ResponseEntity<?> editarSuper(@PathVariable Long id, @RequestBody Supermercado datosSuper){
//        return ResponseEntity.ok(repoSupermercado.save(datosSuper));
//    }
}
//Response maneja estados web
