package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.ConnectionUtil;
import com.example.product_management.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.product_management.repository.ConnectionUtil.entityManager;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        Session session = ConnectionUtil.sessionFactory.openSession();
        productList = session.createQuery("from Product", Product.class).getResultList();
        session.close();
        return productList;
    }

    @Override
    public boolean add(Product product) {
        try {
            Session session = ConnectionUtil.sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(product);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Product product) {
        try {
            Session session = ConnectionUtil.sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setDescription(product.getDescription());
            product1.setProducer(product.getProducer());
            session.save(product1);
            transaction.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Session session = ConnectionUtil.sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Product product = findById(id);
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findByName(String name) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.name = :name";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
