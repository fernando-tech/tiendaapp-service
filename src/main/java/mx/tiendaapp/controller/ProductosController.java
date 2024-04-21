package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.ProductoAltaRequest;
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
	
	@GetMapping("/{idProducto}")
	public ResponseEntity<ProductoDto> producto(@PathVariable Integer idProducto) {
		
		ProductoDto producto = productoService.obtenerProducto(idProducto);
		
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Boolean> altaProducto(@RequestBody ProductoAltaRequest request){
		
		Boolean alta = productoService.altaProducto(request);
		
		return new ResponseEntity<>(alta, HttpStatus.CREATED);
	}
	
	@PutMapping("/{idProducto}")
	public ResponseEntity<Boolean> actualizarProducto(@PathVariable Integer idProducto, @RequestBody ProductoAltaRequest request){
		
		Boolean actualizar = productoService.actualizarProducto(idProducto, request);
		
		return new ResponseEntity<>(actualizar, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idProducto}")
	public ResponseEntity<Boolean> eliminarProducto(@PathVariable Integer idProducto) {
		
		Boolean eliminado = productoService.eliminarProducto(idProducto);
		
		return new ResponseEntity<>(eliminado, HttpStatus.OK);
	} 
	
	@PostMapping("/ventas")
	public ResponseEntity<Boolean> ventaProductos(@RequestBody List<ProductoDto> request){
		
		System.out.println(request.size());
		
		Boolean venta = productoService.ventaProducto(request);
		
		return new ResponseEntity<>(venta, HttpStatus.OK);
	}
	
	
}
