package by.it.academy.repositories;

import by.it.academy.entities.Order;
import by.it.academy.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class OrderRepository implements Repository<Order> {
    @Override
    public void create(Order order) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
    }

    @Override
    public Optional<List<Order>> getAll() {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Order").list();
        transaction.commit();
        return Optional.ofNullable(orders);
    }

    @Override
    public void update(Order order) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
    }

    @Override
    public void delete(Long id) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.delete(order);
        transaction.commit();
    }
}