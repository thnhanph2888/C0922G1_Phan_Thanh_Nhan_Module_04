package com.example.product_management_jpa.repository;

import com.example.product_management_jpa.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(int id);
    Product findById(int id);
    List<Product> findByName(String name);
}
