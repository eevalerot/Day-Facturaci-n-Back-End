package com.daycam.facturar.api.param.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daycam.facturar.api.param.dto.CiudadDto;

@Component
public interface CiudadService {
	
	List<CiudadDto> findCiudadAll();
}
