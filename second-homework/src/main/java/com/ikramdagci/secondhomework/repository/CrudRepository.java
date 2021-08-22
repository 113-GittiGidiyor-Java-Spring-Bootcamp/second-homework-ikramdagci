package com.ikramdagci.secondhomework.repository;

import java.util.List;

public interface CrudRepository<T>{


    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
    void delete(T t);
    T update(T t);

}
