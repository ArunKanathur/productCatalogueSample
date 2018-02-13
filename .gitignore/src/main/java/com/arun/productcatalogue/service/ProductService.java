package com.arun.productcatalogue.service;

import com.arun.productcatalogue.domain.Product;

import java.util.List;

public interface ProductService {

    String addProduct(Product product);

    List<Product> getProductsByType(String type);

    boolean deleteProduct(String id);
}
