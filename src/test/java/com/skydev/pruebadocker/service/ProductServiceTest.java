package com.skydev.pruebadocker.service;

import com.skydev.pruebadocker.dto.ProductDTO;
import com.skydev.pruebadocker.persistence.model.Product;
import com.skydev.pruebadocker.persistence.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void createProduct() {

        //Given

        String nameProduct = "Lapiz";

        ProductDTO productDTO = ProductDTO.builder().name(nameProduct).build();
        Product productReturn = Product.builder().id(1).name(nameProduct).build();
        given(productRepository.save(any())).willReturn(productReturn);

        //When

        Product productResult = productService.createProduct(productDTO);

        //Then

        assertNotNull(productResult);
        assertAll(
                () -> assertEquals(nameProduct, productResult.getName()),
                () -> assertTrue(productResult.getId() > 0)
        );

    }

    @Test
    void getAllProducts() {

        //Given

        List<Product> products = List.of(
                Product.builder().id(1).name("Lapiz").build(),
                Product.builder().id(2).name("Borrador").build()
        );

        given(productRepository.findAll()).willReturn(products);

        //When

        List<Product> productsResult = productService.getAllProducts();

        //Then

        assertNotNull(productsResult);
        assertAll(
                () -> assertFalse(productsResult.isEmpty()),
                () -> assertEquals(products.size(), productsResult.size())
        );

    }
}