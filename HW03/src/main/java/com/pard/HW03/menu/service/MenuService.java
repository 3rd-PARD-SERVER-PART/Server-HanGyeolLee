package com.pard.HW03.menu.service;


import com.pard.HW03.menu.dto.MenuDto;
import com.pard.HW03.menu.entity.Menu;
import com.pard.HW03.menu.repo.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;


    public void save(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .menuId(menuDto.getMenuId())
                .name(menuDto.getName())
                .type(menuDto.getType())
                .price(menuDto.getPrice())
                .build();
        menuRepository.save(menu);
    }

    public MenuDto read(Integer menuId) {
        Menu menu = menuRepository.findById(menuId).get();
        return MenuDto.builder()
                .menuId(menu.getMenuId())
                .name(menu.getName())
                .price(menu.getPrice())
                .type(menu.getType())
                .build();
    }

    public List<MenuDto> readAll() {
        List<Menu> menus = menuRepository.findAll();
        List<MenuDto> menuDtos = menus.stream().map(menu -> MenuDto.builder()
                .menuId(menu.getMenuId())
                .name(menu.getName())
                .price(menu.getPrice())
                .type(menu.getType()).build()).toList();
        return menuDtos;
    }

    public void update(Integer menuId, MenuDto menuDto) {
        Menu menu = menuRepository.findById(menuId).get();
        System.out.println("--------------------------");
        System.out.println(menu.getMenuId() + "  " + menu.getName());
        System.out.println("--------------------------");

//        menu.setMenuId(menuDto.getMenuId());
        menu.setName(menuDto.getName());
        menu.setPrice(menuDto.getPrice());
        menu.setType(menuDto.getType());

        menuRepository.save(menu);
    }

    public void delete(Integer menuId) {
        menuRepository.deleteById(menuId);
    }


    public String getNamebyId(Integer menuId) {
        Menu menu = menuRepository.findMenuByMenuId(menuId);
        return menu.getName();
    }

    public String getTypebyName(String name) {
        Menu menu = menuRepository.findByName(name);
        return menu.getType();
    }

    public List<MenuDto> getMenusByType(String type) {
        List<Menu> menus = menuRepository.findMenusByType(type);
        List<MenuDto> menuDtos = menus.stream().map(menu -> MenuDto.builder()
                .menuId(menu.getMenuId())
                .name(menu.getName())
                .price(menu.getPrice())
                .type(menu.getType()).build()).toList();
        return menuDtos;
    }
}
