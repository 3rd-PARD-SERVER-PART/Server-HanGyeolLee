package com.pard.HW03.menu.repo;

import com.pard.HW03.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Integer> {
//
//    public  User findByUserEmail(String userEmail);
    public List<Menu> findMenusByType(String type);

    public  Menu findByName(String Name);

    public Menu findMenuByMenuId(Integer menuId);
}