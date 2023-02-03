package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "car", 1000, "hong", "Phan Thanh Nhan"));
        productMap.put(2, new Product(2, "bike", 1000, "hong", "Nhan"));
        productMap.put(3, new Product(3, "moto", 1000, "hong", "Phan Nhan"));
        productMap.put(4, new Product(4, "truck", 1000, "hong", "Thanh Nhan"));
    }
    @Override
    public List<Product> getListProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean addProduct(Product product) {
        if (productMap.get(product.getId()) != null) {
            productMap.put(product.getId(), product);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(int idUpdate, Product product) {
        if (productMap.get(product.getId()) != null) {
            productMap.put(product.getId(), product);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int idDelete) {
        if (productMap.get(idDelete) != null) {
            productMap.remove(idDelete);
            return true;
        }
        return false;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productMap.values()) {
            if (product.getName().equals(name)) {
               return product;
            }
        }
        return null;
    }
}
