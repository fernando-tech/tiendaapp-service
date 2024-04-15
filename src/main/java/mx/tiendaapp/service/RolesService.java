package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.tiendaapp.model.Rol;
import mx.tiendaapp.model.DTO.RolDto;
import mx.tiendaapp.repository.IRolesRepository;

@Service
public class RolesService implements IRolesService {

	@Autowired
	private IRolesRepository rolesRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Obtener roles para el empleado
	 */
	@Override
	public List<RolDto> roles() {
		
		List<Rol> roles = rolesRepository.findAll();
		
		List<RolDto> rolesDto = roles.stream().map(r -> mapper.map(r, RolDto.class)).collect(Collectors.toList());
		
		return rolesDto;
	}

}
