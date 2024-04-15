package mx.tiendaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tiendaapp.model.DTO.RolDto;
import mx.tiendaapp.service.IRolesService;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolesController {

	@Autowired
	private IRolesService rolesService;
	
	@GetMapping
	public ResponseEntity<List<RolDto>> marcas(){
		
		List<RolDto> marcas = rolesService.roles();
		
		return new ResponseEntity<>(marcas, HttpStatus.OK);
	}
}
