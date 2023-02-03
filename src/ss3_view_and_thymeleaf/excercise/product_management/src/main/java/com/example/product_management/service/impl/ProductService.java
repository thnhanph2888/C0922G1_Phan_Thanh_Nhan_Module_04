package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.impl.ProductRepository;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getListProduct() {
        return productRepository.getListProduct();
    }

    @Override
    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public boolean updateProduct(int idUpdate, Product product) {
        return productRepository.updateProduct(idUpdate, product);
    }

    @Override
    public boolean deleteProduct(int idDelete) {
        return productRepository.deleteProduct(idDelete);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
