package com.skydev.pruebadocker.service;

import com.skydev.pruebadocker.dto.ProductDTO;
import com.skydev.pruebadocker.persistence.model.Product;
import com.skydev.pruebadocker.persistence.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {
        return productRepository.save(Product.builder()
                .name(productDTO.getName())
                .build());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
