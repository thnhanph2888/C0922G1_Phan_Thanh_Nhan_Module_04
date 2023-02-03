package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getListProduct();
    boolean addProduct(Product product);
    boolean updateProduct(int idUpdate, Product product);
    boolean deleteProduct(int idDelete);

    Product findByName(String name);
}
