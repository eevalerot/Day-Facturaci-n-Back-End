package com.daycam.facturar.api.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daycam.facturar.api.security.entity.Rol;
import com.daycam.facturar.api.security.enums.RolNombre;

@Repository
public interface UsuarioRolRepository extends JpaRepository<Rol, Long>{

	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
