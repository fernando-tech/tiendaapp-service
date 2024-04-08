package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiendaapp.model.Empleado;
import mx.tiendaapp.model.DTO.EmpleadoDto;
import mx.tiendaapp.repository.IEmpleadosRepository;

@Service
public class EmpleadosService implements IEmpleadosService {

	@Autowired
	private IEmpleadosRepository empleadosRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Empleados activos
	 */
	@Override
	public List<EmpleadoDto> empleadosActivos() {
		
		List<Empleado> empleados = empleadosRepository.empleadosActivos();
		
		List<EmpleadoDto> empleadosDto = empleados.stream().map(e -> mapper.map(e, EmpleadoDto.class)).collect(Collectors.toList());
		
		return empleadosDto;
	}

}
