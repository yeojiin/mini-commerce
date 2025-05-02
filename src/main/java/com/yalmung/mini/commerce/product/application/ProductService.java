package com.yalmung.mini.commerce.product.application;

import com.yalmung.mini.commerce.product.model.ProductRepository;
import com.yalmung.mini.commerce.user.model.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
