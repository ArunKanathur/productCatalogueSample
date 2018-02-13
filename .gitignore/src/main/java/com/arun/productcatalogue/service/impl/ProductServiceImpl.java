package com.arun.productcatalogue.service.impl;

import com.arun.productcatalogue.dao.ProductRepository;
import com.arun.productcatalogue.domain.Product;
import com.arun.productcatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) {
        String id = null;
        Product savedProduct = productRepository.save(product);
        if (savedProduct != null) {
            id = savedProduct.getId();
        }
        return id;
    }

    public List<Product> getProductsByType(String type) {
        return productRepository.findByType(type);
    }

    public boolean deleteProduct(String id) {
        boolean result = false;

        Product product = productRepository.findOne(id);
        if (product != null) {
            productRepository.delete(id);
            result = true;
        }

        return result;
    }
}
