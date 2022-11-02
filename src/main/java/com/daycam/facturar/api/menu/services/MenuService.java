package com.daycam.facturar.api.menu.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.daycam.facturar.api.menu.Dto.MenuDto;
import com.daycam.facturar.api.menu.entities.Menu;
import com.daycam.facturar.api.security.entity.Rol;
import com.daycam.facturar.api.security.enums.RolNombre;

@Component
public interface MenuService {

	List<Menu> findByMenu(RolNombre rolNombre);
}
