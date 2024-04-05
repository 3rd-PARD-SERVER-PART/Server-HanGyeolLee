package com.pard.hw2.product.repository;


import com.pard.hw2.Product;
import com.pard.hw2.product.dto.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    public static final Map<Integer, Product> database = new HashMap<>();

    //creat
    public void save(ProductDto crudDto) {
        Product c = Product.builder()
                .id(crudDto.getId())
                .name(crudDto.getName())
                .price(crudDto.getPrice())
                .amount(crudDto.getAmount())
                .build();
        database.put(crudDto.getId(), c);
    }

    public List<ProductDto> findAll(){
        return database.values().stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .amount(product.getAmount())
                        .build()).toList();
    }

    //read
    public ProductDto findById(Integer productId) {
        Product c = database.get(productId);

        return ProductDto.builder()
                .id(c.getId())
                .name(c.getName())
                .price(c.getPrice())
                .amount(c.getAmount())
                .build();
    }

    //update
    public void update(Integer productId, ProductDto n) {
//        Crud c = Crud.builder()
//                .id(n.getId())
//                .name(n.getName())
//                .price(n.getPrice())
//                .amount(n.getAmount())
//                .build();
//        product.put(productId, c);
// 이런 방식으로 생성하는 것도 가능은 한가 질문하기

        Product p = database.get(productId); // 이건 복사 해오는 건가? (레퍼런스 접근이 아닌듯)
        p.setId(n.getId());
        p.setName(n.getName());
        p.setPrice(n.getPrice());
        p.setAmount(n.getAmount());
        database.put(productId, p);
    }

    //delete
    public String delete(Integer productId) {
        if (database.get(productId) == null) return "Error" ;
        database.remove(productId);
        if (database.get(productId) == null) return "Success" ;
        else return "Error" ;
    }
}
