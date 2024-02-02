package com.test.icfes.services;

import java.util.List;
import com.test.icfes.entity.Producto;

public interface IProductoService {

	public List<Producto> listarProductos();
	
	public boolean borrarProductos(Integer idProducto)  throws Exception;
	
	public void guardarProducto(Producto  producto);
	
	public List<Producto> editarProducto(Producto producto)  throws Exception;		
	
}
