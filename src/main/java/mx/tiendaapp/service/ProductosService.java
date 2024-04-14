package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mx.tiendaapp.model.Producto;
import mx.tiendaapp.model.DTO.ProductoDto;
import mx.tiendaapp.repository.IProductosRepository;

@Service
public class ProductosService implements IProductosService {

	@Autowired
	IProductosRepository productosRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Obtener lista de productos
	 */
	@Override
	public Page<ProductoDto> obtenerProductos(Integer page, Integer size) {
		
		Page<Producto> productos = productosRepository.findAll(PageRequest.of(page, size));
		
		List<ProductoDto> productosDto = productos.stream().map(p -> mapper.map(p, ProductoDto.class))
				.collect(Collectors.toList());
		
		return new PageImpl<>(productosDto, productos.getPageable(), productos.getTotalElements());
	}

}
