package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.MarcaDto;
import mx.tiendaapp.service.IMarcasService;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcasController {

	@Autowired
	private IMarcasService marcasSevice;
	
	@GetMapping
	public ResponseEntity<List<MarcaDto>> marcas(){
		
		List<MarcaDto> marcas = marcasSevice.marcas();
		
		return new ResponseEntity<>(marcas, HttpStatus.OK);
	}
}
