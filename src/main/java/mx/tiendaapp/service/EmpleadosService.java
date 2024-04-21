package mx.tiendaapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import mx.tiendaapp.model.Empleado;
import mx.tiendaapp.model.Rol;
import mx.tiendaapp.model.DTO.EmpleadoActualizarDto;
import mx.tiendaapp.model.DTO.EmpleadoAltaRequest;
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
	public Page<EmpleadoDto> empleados(Integer page, Integer size) {
		
		Page<Empleado> empleados = empleadosRepository.findAll(PageRequest.of(page, size));
		
		List<EmpleadoDto> empleadosDto = empleados.stream().map(e -> mapper.map(e, EmpleadoDto.class)).collect(Collectors.toList());
		
		return new PageImpl<>(empleadosDto, empleados.getPageable(), empleados.getTotalElements());
	}

	/**
	 * Alta del empleado
	 */
	@Override
	public Boolean altaEmpleado(EmpleadoAltaRequest request) {
		
		Rol rol = new Rol();
		rol.setIdRol(request.getPuesto());
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNombre(request.getNombre());
		empleadoNuevo.setApellidoPaterno(request.getApellidoPaterno());
		empleadoNuevo.setApellidoMaterno(request.getApellidoMaterno());
		empleadoNuevo.setActivo(true);
		empleadoNuevo.setFechaIngreso(LocalDateTime.now());
		empleadoNuevo.setFechaSalida(null);
		empleadoNuevo.setRol(rol);
		
		try {
			empleadosRepository.save(empleadoNuevo);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * Metodo para eliminar al empleado
	 */
	@Override
	public Boolean eliminarEmpleado(Integer idEmpleado) {
		
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(idEmpleado);
		
		try {
			empleadosRepository.delete(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * Obtener empleado por id
	 */
	@Override
	public EmpleadoDto empleado(Integer idEmpleado) {
		
		Empleado empleado = empleadosRepository.findById(idEmpleado).orElse(null);
		
		if(empleado == null) {
			return null;
		}
		
		EmpleadoDto empleadoDto = mapper.map(empleado, EmpleadoDto.class);
		
		return empleadoDto;
	}

	/**
	 * Actualizar empleado
	 */
	@Override
	public Boolean actualizarEmpleado(Integer idEmpleado, EmpleadoActualizarDto request) {
		
		Empleado empleado = empleadosRepository.findById(idEmpleado).orElse(null);
		
		if(empleado == null) {
			return false;
		}
		
		Rol rol = new Rol();
		rol.setIdRol(request.getPuesto());
		
		empleado.setRol(rol);
		empleado.setActivo(request.getEstatus());
		
		try {
			empleadosRepository.save(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
