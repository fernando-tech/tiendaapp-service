package mx.tiendaapp.service;


import java.util.List;

import org.springframework.data.domain.Page;

import mx.tiendaapp.model.DTO.ProductoAltaRequest;
import mx.tiendaapp.model.DTO.ProductoDto;

public interface IProductosService {

	Page<ProductoDto> obtenerProductos(Integer page, Integer size);

	Boolean altaProducto(ProductoAltaRequest request);

	Boolean ventaProducto(List<ProductoDto> request);

	ProductoDto obtenerProducto(Integer idProducto);

	Boolean actualizarProducto(Integer idProducto, ProductoAltaRequest request);

	Boolean eliminarProducto(Integer idProducto);

}
