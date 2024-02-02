package com.test.icfes.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import com.test.icfes.entity.Producto;

@XmlRootElement(name = "productos")
public class ProductoList {
	
	private List<Producto> producto;

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

}
