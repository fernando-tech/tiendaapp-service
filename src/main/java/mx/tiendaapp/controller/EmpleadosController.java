package mx.tiendaapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.EmpleadoAltaRequest;
import mx.tiendaapp.model.DTO.EmpleadoDto;
import mx.tiendaapp.service.IEmpleadosService;

@RestController
@RequestMapping("/empleados")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadosController {

	@Autowired
	private IEmpleadosService empleadosService;
	
	@GetMapping()
	public ResponseEntity<Page<EmpleadoDto>> empleados(
			@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, value = "size", defaultValue = "100") Integer size){
		
		Page<EmpleadoDto> empleados = empleadosService.empleados(page, size);
		
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Boolean> altaEmpleado(@RequestBody EmpleadoAltaRequest request){
		
		Boolean alta = empleadosService.altaEmpleado(request);
		
		return new ResponseEntity<>(alta, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idEmpleado}")
	public ResponseEntity<Boolean> eliminarEmpleado(@PathVariable Integer idEmpleado){
		
		Boolean eliminado = empleadosService.eliminarEmpleado(idEmpleado);
		
		return new ResponseEntity<>(eliminado, HttpStatus.OK);
	}
}
