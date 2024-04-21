package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mx.tiendaapp.model.Categoria;
import mx.tiendaapp.model.Marca;
import mx.tiendaapp.model.Producto;
import mx.tiendaapp.model.DTO.ProductoAltaRequest;
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

	/*
	 * Alta de productos
	 */
	@Override
	public Boolean altaProducto(ProductoAltaRequest request) {
		
		Marca marca = new Marca();
		marca.setIdMarca(request.getMarca());
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(request.getCategoria());
		
		Producto producto = new Producto();
		producto.setNombreProducto(request.getNombre().toUpperCase());
		producto.setDescripcion(request.getDescripcion());
		producto.setPrecio(request.getPrecio());
		producto.setCodigoProducto(request.getCodigo());
		producto.setInventario(request.getInventario());
		producto.setCategoria(categoria);
		producto.setMarca(marca);
		
		
		try {
			productosRepository.save(producto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean ventaProducto(List<ProductoDto> request) {
		
		return null;
	}

	@Override
	public ProductoDto obtenerProducto(Integer idProducto) {
		
		Producto producto = productosRepository.findById(idProducto).orElse(null);
		
		if(producto == null) {
			return null;
		}
		
		ProductoDto productoDto = mapper.map(producto, ProductoDto.class);
		
		return productoDto;
	}

	/**
	 * Metodo para actualizar el producto
	 */
	@Override
	public Boolean actualizarProducto(Integer idProducto, ProductoAltaRequest request) {
		
		Producto producto = productosRepository.findById(idProducto).orElse(null);
		
		if(producto == null) {
			return null;
		}
		
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(request.getCategoria());
		
		Marca marca = new Marca();
		marca.setIdMarca(request.getMarca());
		
		producto.setNombreProducto(request.getNombre());
		producto.setDescripcion(request.getDescripcion());
		producto.setCodigoProducto(request.getCodigo());
		producto.setPrecio(request.getPrecio());
		producto.setCategoria(categoria);
		producto.setMarca(marca);
		producto.setInventario(request.getInventario());
		
		try {
			productosRepository.save(producto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean eliminarProducto(Integer idProducto) {
		
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		
		try {
			productosRepository.delete(producto);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
