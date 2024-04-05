package com.pard.hw2.product.controller;

import com.pard.hw2.product.dto.ProductDto;
import com.pard.hw2.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("")
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{productId}")
    public ProductDto findById(@PathVariable Integer productId) {
        return productService.findById(productId);
    }

    @GetMapping("")
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PatchMapping("/{productId}")
    public void updateProduct(@PathVariable Integer productId, @RequestBody ProductDto productDto) {
        productService.updateProduct(productId, productDto);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Integer productId) {
        return productService.removeProduct(productId);
    }
}
