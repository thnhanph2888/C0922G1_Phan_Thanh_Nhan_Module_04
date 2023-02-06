package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getListProduct();
    boolean addProduct(Product product);
    boolean updateProduct(int idUpdate, Product product);
    boolean deleteProduct(int idDelete);
    Product findById(int id);
    Product findByName(String name);
}
