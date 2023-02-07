package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

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
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public boolean update(Product product) {
        try {
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setName(product.getProducer());
            product1.setName(product.getDescription());
            product1.setName(product.getProducer());
            entityManager.merge(product1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        try {
            Product product = findById(id);
            entityManager.remove(product);
        } catch (Exception e) {
            return false;
        }
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
