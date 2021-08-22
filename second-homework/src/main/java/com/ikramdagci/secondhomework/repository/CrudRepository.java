package com.ikramdagci.secondhomework.repository;

import java.util.List;

public interface CrudRepository<T>{

    List<T> findAll();
    T findById(Long id);
    void saveToDatabase(T object);
    void deleteFromDatabase(T object);
    void deleteFromDatabase(Long id);
    void updateOnDatabase(T object, Long id);

}
