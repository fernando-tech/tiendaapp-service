package mx.tiendaapp.service;


import org.springframework.data.domain.Page;

import mx.tiendaapp.model.DTO.ProveedorAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioActualizarDto;
import mx.tiendaapp.model.DTO.UsuarioAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioDto;

public interface IUsuariosService {

	Page<UsuarioDto> empleados(Integer page, Integer size);

	Boolean altaEmpleado(UsuarioAltaRequest request);

	Boolean eliminarEmpleado(Integer idEmpleado);

	UsuarioDto empleado(Integer idEmpleado);

	Boolean actualizarEmpleado(Integer idEmpleado, UsuarioActualizarDto request);

	Page<UsuarioDto> proveedores(Integer page, Integer size);

	Boolean altaProveedor(ProveedorAltaRequest request);

	Boolean actualizarProveedor(Integer idUsuario, ProveedorAltaRequest request);

	Boolean eliminarProveedor(Integer idUsuario);
}
