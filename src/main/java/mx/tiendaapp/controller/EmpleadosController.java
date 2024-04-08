package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.EmpleadoDto;
import mx.tiendaapp.service.IEmpleadosService;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	private IEmpleadosService empleadosService;
	
	@GetMapping()
	public ResponseEntity<List<EmpleadoDto>> empleados(){
		
		List<EmpleadoDto> empleados = empleadosService.empleadosActivos();
		
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
}
