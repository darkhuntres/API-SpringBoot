package com.unicaes.lab02pubilpreza.persistence.repository;

import com.unicaes.lab02pubilpreza.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(Long id);

    // Filtrar por nombre
    List<Producto> findAllByNombre(String nombre);

    // Filtrar por categoría
    List<Producto> findAllByCategoria(String categoria);

    // Filtrar por precio
    List<Producto> findAllByPrecio(double precio);

    // Filtrar por stock
    List<Producto> findAllByStock(int stock);

    // Actualizar producto por ID
    @Modifying
    @Query("UPDATE Producto p SET p.nombre = :nombre, p.descripcion = :descripcion, p.precio = :precio, p.categoria = :categoria, p.stock = :stock WHERE p.id = :id")
    void updateProducto(@Param("id") Long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("precio") double precio, @Param("categoria") String categoria, @Param("stock") int stock);

    // Eliminar producto por ID
    @Modifying
    @Query("DELETE FROM Producto p WHERE p.id = :id")
    void deleteProductoById(@Param("id") Long id);
}
