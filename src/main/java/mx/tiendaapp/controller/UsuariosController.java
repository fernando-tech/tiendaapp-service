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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.ProveedorAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioActualizarDto;
import mx.tiendaapp.model.DTO.UsuarioAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioDto;
import mx.tiendaapp.service.IUsuariosService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {

	@Autowired
	private IUsuariosService empleadosService;
	
	@GetMapping("/empleados")
	public ResponseEntity<Page<UsuarioDto>> empleados(
			@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, value = "size", defaultValue = "100") Integer size){
		
		Page<UsuarioDto> empleados = empleadosService.empleados(page, size);
		
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@GetMapping("/proveedores")
	public ResponseEntity<Page<UsuarioDto>> proveedores(
			@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, value = "size", defaultValue = "100") Integer size){
		
		Page<UsuarioDto> proveedores = empleadosService.proveedores(page, size);
		
		return new ResponseEntity<>(proveedores, HttpStatus.OK);
	}
	
	@GetMapping("/empleados/{idEmpleado}")
	public ResponseEntity<UsuarioDto> empleado(@PathVariable Integer idEmpleado){
		
		UsuarioDto empleado = empleadosService.empleado(idEmpleado);
		
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Boolean> altaEmpleado(@RequestBody UsuarioAltaRequest request){
		
		Boolean alta = empleadosService.altaEmpleado(request);
		
		return new ResponseEntity<>(alta, HttpStatus.CREATED);
	}
	
	@PostMapping("/proveedores")
	public ResponseEntity<Boolean> altaProveedor(@RequestBody ProveedorAltaRequest request){
		
		Boolean alta = empleadosService.altaProveedor(request);
		
		return new ResponseEntity<>(alta, HttpStatus.CREATED);
	}
	
	@PutMapping("/empleados/{idEmpleado}")
	public ResponseEntity<Boolean> actualizarEmpleado(@PathVariable Integer idEmpleado, @RequestBody UsuarioActualizarDto request){
		
		Boolean update = empleadosService.actualizarEmpleado(idEmpleado, request);
		
		return new ResponseEntity<>(update, HttpStatus.CREATED);
	}
	
	@PutMapping("/proveedores/{idUsuario}")
	public ResponseEntity<Boolean> actualizarProveedor(@PathVariable Integer idUsuario, @RequestBody ProveedorAltaRequest request){
		
		Boolean update = empleadosService.actualizarProveedor(idUsuario, request);
		
		return new ResponseEntity<>(update, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/empleados/{idEmpleado}")
	public ResponseEntity<Boolean> eliminarEmpleado(@PathVariable Integer idEmpleado){
		
		Boolean eliminado = empleadosService.eliminarEmpleado(idEmpleado);
		
		return new ResponseEntity<>(eliminado, HttpStatus.OK);
	}
	
	@DeleteMapping("/proveedores/{idUsuario}")
	public ResponseEntity<Boolean> eliminarProveedor(@PathVariable Integer idUsuario){
		
		Boolean eliminado = empleadosService.eliminarProveedor(idUsuario);
		
		return new ResponseEntity<>(eliminado, HttpStatus.OK);
	}
}
