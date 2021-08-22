package com.ikramdagci.secondhomework.repository;

import java.util.List;

public interface CrudRepository<T>{


    List<T> findAll();
    T findById(Long id);
    T save(T object);
    void deleteById(Long id);
    void deleteFromDatabase(T object);
    T update(T object);

}
