package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User> {

    public void create(User user) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    public Optional<List<User>> getAll() {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        return Optional.ofNullable(users);
    }

    public Optional<User> getUserByNameAndPassword(String login, String password) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User WHERE login =: login AND password =: password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        Optional<User> user = query.getResultList().stream().findFirst();
        transaction.commit();
        return user;
    }

    public void update(User user) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    public void delete(Long id) {
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
    }
}