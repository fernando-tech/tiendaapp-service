package mx.tiendaapp.service;


import org.springframework.data.domain.Page;

import mx.tiendaapp.model.DTO.ProductoDto;

public interface IProductosService {

	Page<ProductoDto> obtenerProductos(Integer page, Integer size);

}
