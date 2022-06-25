package by.it.academy.repositories;

import by.it.academy.entities.Product;
import by.it.academy.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements Repository<Product>{
    @Override
    public void create(Product product) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
    }

    @Override
    public Optional<List<Product>> getAll() {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = session.createQuery("FROM Product").list();
        transaction.commit();
        return Optional.ofNullable(products);
    }

    public Optional<List<Product>> getAvailable() {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Product WHERE amount > 0");
        List<Product> products = query.getResultList();
        return Optional.ofNullable(products);
    }

    @Override
    public void update(Product product) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
    }

    @Override
    public void delete(Long id) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
    }
}