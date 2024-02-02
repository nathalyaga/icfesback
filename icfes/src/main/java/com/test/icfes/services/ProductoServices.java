package com.test.icfes.services;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.icfes.entity.Producto;
import com.test.icfes.repository.ProductoRepository;

@Service
@Transactional
public class ProductoServices implements IProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarProductos() {
		return productoRepository.buscarProducto();
	}

	@Override
	public boolean borrarProductos(Integer idProducto) throws Exception {
		productoRepository.deleteById(idProducto);
		return true;
	}

	@Override
	public void guardarProducto(Producto producto) {
		Producto productoSv = productoRepository.save(producto);
	}

	@Override
	public List<Producto> editarProducto(Producto producto) throws Exception {
		List<Producto> lsProducto = null;	
		Producto productoSv = productoRepository.findById(producto.getIdProducto()).get();
		productoSv.setNombreProducto(producto.getNombreProducto());
		productoSv.setPrecio(producto.getPrecio());
		productoSv.setTipoMaterial(producto.getTipoMaterial());
		productoSv.setTipoProducto(producto.getTipoProducto());
		productoSv.setCantidadDisponible(producto.getCantidadDisponible());
		productoSv.setPeso(producto.getPeso());
		productoSv.setMedidas(producto.getMedidas());
		productoSv.setColor(producto.getColor());
		productoSv.setFechaEdito(new Date());
		productoRepository.save(productoSv);		
		
		lsProducto = productoRepository.buscarProducto();
		return lsProducto;
	}

}
