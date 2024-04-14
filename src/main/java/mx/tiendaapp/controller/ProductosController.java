package mx.tiendaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.ProductoDto;
import mx.tiendaapp.service.IProductosService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosController {

	@Autowired
	private IProductosService productoService;
	
	@GetMapping
	public ResponseEntity<Page<ProductoDto>> productos(
			@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, value = "size", defaultValue = "10") Integer size) {
		
		Page<ProductoDto> productos = productoService.obtenerProductos(page, size);
		
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
}
