package mx.tiendaapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiendaapp.model.Marca;
import mx.tiendaapp.model.DTO.MarcaDto;
import mx.tiendaapp.repository.IMarcasRepository;

@Service
public class MarcasService implements IMarcasService {

	@Autowired
	IMarcasRepository marcaRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<MarcaDto> marcas() {
		
		List<Marca> marcas = marcaRepository.findAll();
		
		List<MarcaDto> marcasDto = marcas.stream().map(m -> mapper.map(m, MarcaDto.class)).collect(Collectors.toList());
		
		return marcasDto;
	}
	
}
