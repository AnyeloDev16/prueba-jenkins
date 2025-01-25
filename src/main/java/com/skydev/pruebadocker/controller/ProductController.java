package com.skydev.pruebadocker.controller;

import com.skydev.pruebadocker.dto.ProductDTO;
import com.skydev.pruebadocker.persistence.model.Product;
import com.skydev.pruebadocker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productDTO));

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());

    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
