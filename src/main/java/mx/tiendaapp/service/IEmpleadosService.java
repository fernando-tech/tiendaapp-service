package mx.tiendaapp.service;

import java.util.List;

import mx.tiendaapp.model.DTO.EmpleadoDto;

public interface IEmpleadosService {

	List<EmpleadoDto> empleadosActivos();
}
