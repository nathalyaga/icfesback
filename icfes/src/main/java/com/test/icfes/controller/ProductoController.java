package com.test.icfes.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.icfes.entity.Producto;
import com.test.icfes.model.ProductoList;
import com.test.icfes.model.ResponseModel;
import com.test.icfes.services.IProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ProductoController {
	
	@Autowired
	IProductoService productoService;

	@PostMapping("/guardarProducto")
	public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) throws IOException {

		ResponseModel response = new ResponseModel();
		try {
			productoService.guardarProducto(producto);
			response.setCode(HttpStatus.OK.value());
			response.setMessage("Registro guardado exitosamente");

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Ha ocurrido un error al consumir el servicio :" + e.getMessage());
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/listarProducto")
	public ResponseEntity<?>  listarProducto() {
		ResponseModel response = new ResponseModel();
		List<Producto> list = null;
		ProductoList productosLs = new ProductoList();;
		try {
			list = productoService.listarProductos();	
			productosLs.setProducto(list);
			response.setCode(HttpStatus.OK.value());
			response.setMessage("Registro guardado exitosamente");
			response.setBody(productosLs);
			return new ResponseEntity(response, HttpStatus.OK);

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Ha ocurrido un error al consumir el servicio :" + e.getMessage());
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/actualizarProducto")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) throws IOException {
		List<Producto> productosLs = null;
		ResponseModel response = new ResponseModel();
		try {
			productosLs = productoService.editarProducto(producto);
			response.setCode(HttpStatus.OK.value());
			response.setMessage("Actualización exitosa");
			response.setBody(productosLs);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Ha ocurrido un error al consumir el servicio :" + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/borrarProductos")
	public ResponseEntity<?> borrarProductos(@RequestParam("idProducto") Integer idProducto) throws IOException {

		ResponseModel response = new ResponseModel();
		try {
			productoService.borrarProductos(idProducto);
			response.setCode(HttpStatus.OK.value());
			response.setMessage("Registro borrado exitosamente");

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Ha ocurrido un error al consumir el servicio :" + e.getMessage());
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	
}
