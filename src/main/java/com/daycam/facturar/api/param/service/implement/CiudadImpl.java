package com.daycam.facturar.api.param.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.commons.MHelpers;
import com.daycam.facturar.api.param.dto.CiudadDto;
import com.daycam.facturar.api.param.entities.Ciudad;
import com.daycam.facturar.api.param.repositories.CiudadRepository;
import com.daycam.facturar.api.param.service.CiudadService;

@Service
public class CiudadImpl implements CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<CiudadDto> findCiudadAll() {
		List<CiudadDto> ciudadList = new ArrayList<>();
		Iterable<Ciudad> listaCiudad = ciudadRepository.findAll();
		
		for (Ciudad ciudad : listaCiudad) {
			CiudadDto c = MHelpers.modelMapper().map(ciudad, CiudadDto.class);
			ciudadList.add(c);
		}
		
		return ciudadList;
	}
	
}
