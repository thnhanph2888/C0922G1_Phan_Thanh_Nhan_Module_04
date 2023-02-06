package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("from Product").getResultList();
        return productList;
    }

    @Transactional
    @Override
    public boolean add(Product product) {
            entityManager.persist(product);
        return true;
    }
    @Transactional
    @Override
    public boolean update(Product product) {
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setName(product.getProducer());
            product1.setName(product.getDescription());
            product1.setName(product.getProducer());
            entityManager.merge(product1);
        return true;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
            Product product = findById(id);
            entityManager.remove(product);
        return true;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        for (Product product: productList) {
            if (product.getName().equals(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
