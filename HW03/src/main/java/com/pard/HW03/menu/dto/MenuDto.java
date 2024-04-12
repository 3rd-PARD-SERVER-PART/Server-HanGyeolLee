package com.pard.HW03.menu.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDto {
    private  Integer menuId;

    private String name;

    private String type;

    private Integer price;

}
