package mx.tiendaapp.service;

import java.util.List;

import mx.tiendaapp.model.DTO.ProductoDto;

public interface IProductosService {

	List<ProductoDto> obtenerProductos();

}
