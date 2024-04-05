package com.pard.hw2.product.service;


import com.pard.hw2.product.dto.ProductDto;
import com.pard.hw2.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(ProductDto productDto) {
        productRepository.save(productDto);
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll();
    }

    public ProductDto findById(Integer id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Integer id, ProductDto productDto) {
        productRepository.update(id, productDto);
    }

    public String removeProduct(Integer id) {
        return productRepository.delete(id);
    }
}
