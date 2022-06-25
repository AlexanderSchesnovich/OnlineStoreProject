package by.it.academy.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    void create(T t);
    Optional<List<T>> getAll();
    void update(T t);
    void delete(Long id);
}