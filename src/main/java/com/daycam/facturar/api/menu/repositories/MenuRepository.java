package com.daycam.facturar.api.menu.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daycam.facturar.api.menu.entities.Menu;
import com.daycam.facturar.api.security.entity.Rol;
import com.daycam.facturar.api.security.entity.Usuario;
import com.daycam.facturar.api.security.enums.RolNombre;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	@Query("SELECT m FROM Menu m WHERE m.estado = true AND m.rol.rolNombre = :rolNombre")
	List<Menu> findMenu(@Param("rolNombre") RolNombre rolNombre);
	
}
