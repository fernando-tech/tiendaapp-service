package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.CategoriaDto;
import mx.tiendaapp.service.ICategoriasService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriasController {

	@Autowired
	private ICategoriasService categoriasService;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDto>> categorias() {
		
		List<CategoriaDto> categorias = categoriasService.categorias();
		
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}
}
