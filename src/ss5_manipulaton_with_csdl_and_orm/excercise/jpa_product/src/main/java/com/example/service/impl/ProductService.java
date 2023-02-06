package com.example.service.impl;
import com.example.model.Product;
import com.example.repository.impl.ProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
       return productRepository.add(product);
    }

    @Override
    public boolean update(Product product) {
       return productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
       return productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
