package com.unicaes.lab02pubilpreza.controller;

import com.unicaes.lab02pubilpreza.service.ProductoService;
import com.unicaes.lab02pubilpreza.service.dto.ProductoInDTO;
import com.unicaes.lab02pubilpreza.persistence.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto createProducto(@RequestBody ProductoInDTO productoInDTO) {
        return this.productoService.createProducto(productoInDTO);
    }

    @GetMapping("/listar")
    public List<Producto> findAll(){
        return this.productoService.findAll();
    }

    @GetMapping("/listarPorId/{id}")
    public Optional<Producto> findById(@PathVariable Long id){
        return this.productoService.findById(id);
    }

    @GetMapping("/nombre")
    public List<Producto> findByNombre(@RequestParam String nombre){
        return this.productoService.findByNombre(nombre);
    }

    @GetMapping("/categoria")
    public List<Producto> findByCategoria(@RequestParam String categoria){
        return this.productoService.findByCategoria(categoria);
    }

    @GetMapping("/precio")
    public List<Producto> findByPrecio(@RequestParam double precio){
        return this.productoService.findByPrecio(precio);
    }

    @GetMapping("/stock")
    public List<Producto> findByStock(@RequestParam int stock){
        return this.productoService.findByStock(stock);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody ProductoInDTO productoInDTO) {
        return this.productoService.updateProducto(id, productoInDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        this.productoService.deleteProducto(id);
    }
}
