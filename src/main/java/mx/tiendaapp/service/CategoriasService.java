package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiendaapp.model.Categoria;
import mx.tiendaapp.model.DTO.CategoriaDto;
import mx.tiendaapp.repository.ICategoriasRepository;

@Service
public class CategoriasService implements ICategoriasService {

	@Autowired
	private ICategoriasRepository categoriasRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	/**
	 * Servicio que entrega las categorias de los productos
	 */
	@Override
	public List<CategoriaDto> categorias() {
		
		List<Categoria> categorias = categoriasRepository.findAll();
		
		List<CategoriaDto> categoriasDto = categorias.stream().map(c -> {
			return mapper.map(c, CategoriaDto.class);
		}).collect(Collectors.toList());
		
		return categoriasDto;
	}

}
