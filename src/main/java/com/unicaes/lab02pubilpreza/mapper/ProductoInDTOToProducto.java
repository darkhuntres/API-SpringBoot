package com.unicaes.lab02pubilpreza.mapper;

import com.unicaes.lab02pubilpreza.persistence.entity.Producto;
import com.unicaes.lab02pubilpreza.service.dto.ProductoInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoInDTOToProducto implements IMapper<ProductoInDTO , Producto>{

    @Override
    public Producto map(ProductoInDTO in) {
        Producto producto = new Producto();
        producto.setNombre(in.getNombre());
        producto.setDescripcion(in.getDescripcion());
        producto.setPrecio(in.getPrecio());
        producto.setCategoria(in.getCategoria());
        producto.setStock(in.getStock());
        return producto; // Devolver el objeto Producto creado y configurado
    }
}
