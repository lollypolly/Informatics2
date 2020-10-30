package ru.itis.repositories;

import java.util.List;

public interface CrudRepository<T> {
    void save(T entity);
    List<T> findAll();
}
