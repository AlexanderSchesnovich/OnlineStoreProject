package by.it.academy.services;

import java.util.List;

interface Service<T> {
    void create(T t);
    List<T> getAll();
    void update(T t);
    void delete(int id);
}
