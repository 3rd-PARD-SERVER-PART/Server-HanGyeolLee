package com.pard.thirdseminar.menu.repo;

import com.pard.thirdseminar.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Integer> {
//
    public Menu findMenuByMenuId(Integer id);

    public  Menu findByName(String Name);

    public List<Menu> findByPriceLessThan(Integer price);
}