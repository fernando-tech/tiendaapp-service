package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.ProductoDto;
import mx.tiendaapp.service.IProductosService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private IProductosService productoService;
	
	@GetMapping
	public ResponseEntity<List<ProductoDto>> productos() {
		
		List<ProductoDto> productos = productoService.obtenerProductos();
		
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
}
