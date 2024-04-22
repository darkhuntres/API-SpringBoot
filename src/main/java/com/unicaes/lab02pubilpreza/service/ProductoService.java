package com.unicaes.lab02pubilpreza.service;

import com.unicaes.lab02pubilpreza.mapper.ProductoInDTOToProducto;
import com.unicaes.lab02pubilpreza.persistence.entity.Producto;
import com.unicaes.lab02pubilpreza.persistence.repository.ProductoRepository;
import com.unicaes.lab02pubilpreza.service.dto.ProductoInDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final ProductoInDTOToProducto mapper;

    public ProductoService(ProductoRepository repository, ProductoInDTOToProducto mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Producto createProducto(ProductoInDTO productoInDTO) {
        Producto producto = mapper.map(productoInDTO);

       return this.repository.save(producto);
    }

    public List<Producto> findAll(){
        return this.repository.findAll();
    }

    public Optional<Producto> findById(Long id){
        return this.repository.findById(id);
    }

    public List<Producto> findByNombre(String nombre){
        return this.repository.findAllByNombre(nombre);
    }
    public List<Producto> findByCategoria(String categoria){
        return this.repository.findAllByCategoria(categoria);
    }
    public List<Producto> findByPrecio(double precio){
        return this.repository.findAllByPrecio(precio);
    }

    public List<Producto> findByStock(int stock){
        return this.repository.findAllByStock(stock);
    }
    public Producto updateProducto(Long id, ProductoInDTO productoInDTO) {
        Optional<Producto> optionalProducto = repository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();
            Producto updatedProducto = mapper.map(productoInDTO);
            updatedProducto.setId(producto.getId());
            return repository.save(updatedProducto);
        } else {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
    }

    public void deleteProducto(Long id) {
        Optional<Producto> optionalProducto = repository.findById(id);
        if (optionalProducto.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
    }

}
