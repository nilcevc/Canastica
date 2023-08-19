package com.vcc.canastica.controladores;

import com.vcc.canastica.DTO.NewProductoDTO;
import com.vcc.canastica.DTO.ProductoDTO;
import com.vcc.canastica.DTO.SupermercadosXProductoDTO;
import com.vcc.canastica.modelos.Marca;
import com.vcc.canastica.modelos.Producto;
import com.vcc.canastica.modelos.ProductoXSupermercado;
import com.vcc.canastica.repositorios.RepositorioMarca;
import com.vcc.canastica.repositorios.RepositorioProducto;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("producto")
public class ControladorProducto {
    private final RepositorioProducto repoProducto;
    private final RepositorioMarca repoMarca;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repoProducto.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProducto(@PathVariable Long id){
        ProductoDTO producto = new ProductoDTO();
        Producto prodTemp = repoProducto.findById(id).orElse(null);
        if (prodTemp == null){
            return ResponseEntity.notFound().build();
        }
        producto.setNombre(prodTemp.getNombre());
        producto.setDescripcion(prodTemp.getDescripcion());
        producto.setNombreMarca(prodTemp.getMarca().getNombre());

        ArrayList<SupermercadosXProductoDTO> supermercadosXProductoDTOList = new ArrayList<>();
        for (ProductoXSupermercado prodXsuper: prodTemp.getSupermercados()) {
            SupermercadosXProductoDTO superxproddto = new SupermercadosXProductoDTO();
            superxproddto.setPrecio(prodXsuper.getPrecio());
            superxproddto.setNombreSuper(prodXsuper.getSupermercado().getNombre());
            superxproddto.setUbicacion(prodXsuper.getSupermercado().getUbicacion());
            supermercadosXProductoDTOList.add(superxproddto);
        }
        producto.setSupermercadosXProductoDTOList(supermercadosXProductoDTOList);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<?> agregarProducto(@RequestBody NewProductoDTO newProd){
        Producto producto = new Producto();
        producto.setDescripcion(newProd.getDescripcion());
        producto.setNombre(newProd.getNombre());
        producto.setCodigo(newProd.getCodigo());
        Marca marca = repoMarca.findById(newProd.getIdMarca()).orElse(null);
        producto.setMarca(marca);

        return ResponseEntity.ok(repoProducto.save(producto));
    }

    @DeleteMapping({"codigo"})
    public ResponseEntity<?> borrarProducto(@PathVariable Long codigo){
        repoProducto.deleteById(codigo);
        return ResponseEntity.ok().build();
    }


}
