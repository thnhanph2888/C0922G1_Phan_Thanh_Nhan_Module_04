package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(int id);
    Product findById(int id);
    List<Product> findByName(String name);
}
