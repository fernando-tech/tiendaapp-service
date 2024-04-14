package mx.tiendaapp.service;


import org.springframework.data.domain.Page;

import mx.tiendaapp.model.DTO.EmpleadoDto;

public interface IEmpleadosService {

	Page<EmpleadoDto> empleados(Integer page, Integer size);
}
