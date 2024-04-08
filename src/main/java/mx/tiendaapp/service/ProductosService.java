package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<ProductoDto> obtenerProductos() {
		List<Producto> productos = productosRepository.findAll();
		
		List<ProductoDto> productosDto = productos.stream().map(p -> {
			return mapper.map(p, ProductoDto.class);
		}).collect(Collectors.toList());
		
		return productosDto;
	}

}
