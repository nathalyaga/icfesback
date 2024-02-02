package com.test.icfes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.test.icfes.entity.Producto;

@Repository
public interface ProductoRepository extends  JpaRepository<Producto, Integer>{


	 @Query(value = "SELECT P.* FROM producto P ORDER BY P.nombre_producto ASC", nativeQuery = true)
	 public List<Producto> buscarProducto();
	
}
