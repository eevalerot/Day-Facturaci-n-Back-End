package com.daycam.facturar.api.menu.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daycam.facturar.api.commons.MHelpers;
import com.daycam.facturar.api.menu.Dto.MenuDto;
import com.daycam.facturar.api.menu.entities.Menu;
import com.daycam.facturar.api.menu.repositories.MenuRepository;
import com.daycam.facturar.api.menu.services.MenuService;
import com.daycam.facturar.api.security.entity.Rol;
import com.daycam.facturar.api.security.enums.RolNombre;

@Service
public class MenuImpl implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> findByMenu(RolNombre rolNombre) {
		
		List<Menu> listMenu = new ArrayList<>();
		
		try {
			Iterable<Menu> listaMenu = this.menuRepository.findMenu(rolNombre);
			
			for (Menu menuList : listaMenu) {
				Menu menu = MHelpers.modelMapper().map(menuList, Menu.class);
				listMenu.add(menu);
			}
			
			return listMenu;
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.print("error al traer el Menu "+e.getMessage());
		}
		return null;
	}

}
