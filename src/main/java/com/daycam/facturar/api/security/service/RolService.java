package com.daycam.facturar.api.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.security.entity.Rol;
import com.daycam.facturar.api.security.enums.RolNombre;
import com.daycam.facturar.api.security.repository.UsuarioRolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	UsuarioRolRepository usuarioRolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
		
		return usuarioRolRepository.findByRolNombre(rolNombre);
		
	}
}
