package ru.javawebinar.topjava.repository;

import java.util.Collection;

public interface Repository<T> {
    void save(T entity);

    T get(Integer id);

    void delete(Integer id);

    Collection<T> getAll();
}