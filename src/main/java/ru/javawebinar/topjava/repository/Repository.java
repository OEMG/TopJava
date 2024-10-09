package ru.javawebinar.topjava.repository;

import java.util.List;

public interface Repository<T> {
    T save(T entity);

    T get(int id);

    void delete(int id);

    List<T> getAll();
}