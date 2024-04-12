package com.pard.HW03.menu.controller;

import com.pard.HW03.menu.dto.MenuDto;
import com.pard.HW03.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;


    @PostMapping("")
    public void save(@RequestBody MenuDto menuDto) {
        menuService.save(menuDto);
    }

    @GetMapping("/{menuId}")
    public MenuDto readById(@PathVariable Integer menuId) {
        return menuService.read(menuId);
    }

    @GetMapping("")
    public List<MenuDto> readAll() {
        return menuService.readAll();
    }

    @PatchMapping("/{menuId}")
    public void update(@PathVariable Integer menuId, @RequestBody MenuDto menuDto) {
        menuService.update(menuId, menuDto);
    }

    @DeleteMapping("/{menuId}")
    public void delete(@PathVariable Integer menuId) {
        menuService.delete(menuId);
    }

    //-----------------------------------------------

    @GetMapping("name/{menuId}")
    public String readNameById(@PathVariable Integer menuId){
        return  menuService.getNamebyId(menuId);
    }

    @GetMapping("type/{name}")
    public String readNameById(@PathVariable String name){
        return  menuService.getTypebyName(name);
    }

    @GetMapping("{type}")
    public List<MenuDto> readMenusByType(@PathVariable String type){
        return menuService.getMenusByType(type);
    }
}