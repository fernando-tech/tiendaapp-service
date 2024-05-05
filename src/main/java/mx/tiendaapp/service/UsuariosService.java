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


import mx.tiendaapp.model.Usuario;
import mx.tiendaapp.model.Proveedor;
import mx.tiendaapp.model.Rol;
import mx.tiendaapp.model.DTO.ProveedorAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioActualizarDto;
import mx.tiendaapp.model.DTO.UsuarioAltaRequest;
import mx.tiendaapp.model.DTO.UsuarioDto;
import mx.tiendaapp.repository.IProveedoresRepository;
import mx.tiendaapp.repository.IUsuariosRepository;

@Service
public class UsuariosService implements IUsuariosService {

	@Autowired
	private IUsuariosRepository usuariosRepository;
	
	@Autowired
	private IProveedoresRepository prRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Empleados activos
	 */
	@Override
	public Page<UsuarioDto> empleados(Integer page, Integer size) {
		
		Page<Usuario> empleados = usuariosRepository.findAll(PageRequest.of(page, size));
		
		List<UsuarioDto> empleadosDto = empleados.stream()
				.filter(e -> !e.isExterno())
				.map(e -> mapper.map(e, UsuarioDto.class)).collect(Collectors.toList());
		
		return new PageImpl<>(empleadosDto, empleados.getPageable(), empleados.getTotalElements());
	}

	/**
	 * Alta del empleado
	 */
	@Override
	public Boolean altaEmpleado(UsuarioAltaRequest request) {
		
		Rol rol = new Rol();
		rol.setIdRol(request.getPuesto());
		
		Usuario empleadoNuevo = new Usuario();
		empleadoNuevo.setNombre(request.getNombre());
		empleadoNuevo.setApellidoPaterno(request.getApellidoPaterno());
		empleadoNuevo.setApellidoMaterno(request.getApellidoMaterno());
		empleadoNuevo.setActivo(true);
		empleadoNuevo.setFechaIngreso(LocalDateTime.now());
		empleadoNuevo.setFechaSalida(null);
		empleadoNuevo.setRol(rol);
		
		try {
			usuariosRepository.save(empleadoNuevo);
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
		
		Usuario empleado = new Usuario();
		empleado.setIdUsuario(idEmpleado);
		
		try {
			usuariosRepository.delete(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * Obtener empleado por id
	 */
	@Override
	public UsuarioDto empleado(Integer idEmpleado) {
		
		Usuario empleado = usuariosRepository.findById(idEmpleado).orElse(null);
		
		if(empleado == null) {
			return null;
		}
		
		UsuarioDto empleadoDto = mapper.map(empleado, UsuarioDto.class);
		
		return empleadoDto;
	}

	/**
	 * Actualizar empleado
	 */
	@Override
	public Boolean actualizarEmpleado(Integer idEmpleado, UsuarioActualizarDto request) {
		
		Usuario empleado = usuariosRepository.findById(idEmpleado).orElse(null);
		
		if(empleado == null) {
			return false;
		}
		
		Rol rol = new Rol();
		rol.setIdRol(request.getPuesto());
		
		empleado.setRol(rol);
		empleado.setActivo(request.getEstatus());
		
		try {
			usuariosRepository.save(empleado);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * Metodo que regresa los proveedores
	 */
	@Override
	public Page<UsuarioDto> proveedores(Integer page, Integer size) {
		
		Page<Usuario> proveedores = usuariosRepository.findAll(PageRequest.of(page, size));
		
		List<UsuarioDto> proveedoresDto = proveedores.stream()
				.filter(e -> e.isExterno())
				.map(e -> mapper.map(e, UsuarioDto.class)).collect(Collectors.toList());
		
		return new PageImpl<>(proveedoresDto, proveedores.getPageable(), proveedores.getTotalElements());
	}

	@Override
	public Boolean altaProveedor(ProveedorAltaRequest request) {
		
		Rol rol = new Rol();
		rol.setIdRol(5);
		
		Proveedor pr = new Proveedor();
		pr.setDireccion(request.getDireccion());
		pr.setNombre(request.getNombreCompania());
		pr.setRfc(request.getRfc());
		pr.setTelefono(request.getTelefono());
		
		Usuario prNuevo = new Usuario();
		prNuevo.setNombre(request.getNombre());
		prNuevo.setApellidoPaterno(request.getApellidoPaterno());
		prNuevo.setApellidoMaterno(request.getApellidoMaterno());
		prNuevo.setActivo(true);
		prNuevo.setFechaIngreso(LocalDateTime.now());
		prNuevo.setFechaSalida(null);
		prNuevo.setRol(rol);
		prNuevo.setExterno(true);
		prNuevo.setProveedor(prRepository.save(pr));
		
		try {
			usuariosRepository.save(prNuevo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean actualizarProveedor(Integer idUsuario, ProveedorAltaRequest request) {
		
        Usuario usuario = usuariosRepository.findById(idUsuario).orElse(null);
		
		if(usuario == null || usuario.getProveedor() == null) {
			return false;
		}
		
		Proveedor proveedor = prRepository.findById(usuario.getProveedor().getIdProveedor()).orElse(null);
		
		if(proveedor == null) {
			return false;
		}
		
		proveedor.setDireccion(request.getDireccion());
		proveedor.setNombre(request.getNombreCompania());
		proveedor.setRfc(request.getRfc());
		proveedor.setTelefono(request.getTelefono());
		
		usuario.setNombre(request.getNombre());
		usuario.setApellidoPaterno(request.getApellidoPaterno());
		usuario.setApellidoMaterno(request.getApellidoMaterno());
		usuario.setActivo(true);
		usuario.setProveedor(prRepository.save(proveedor));
		
		try {
			usuariosRepository.save(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * Metodo para eliminar el proveedor
	 */
	@Override
	public Boolean eliminarProveedor(Integer idUsuario) {
		
		Usuario usuario = usuariosRepository.findById(idUsuario).orElse(null);
		
		if(usuario == null || usuario.getProveedor() == null) {
			return false;
		}
		
		Proveedor proveedor = prRepository.findById(usuario.getProveedor().getIdProveedor()).orElse(null);
		
		if(proveedor == null) {
			return false;
		}
		
		try {
			prRepository.delete(proveedor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
