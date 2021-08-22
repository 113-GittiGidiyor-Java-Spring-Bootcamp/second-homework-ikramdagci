package com.ikramdagci.secondhomework.dao.data.access.definition;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T object);
    void deleteById(Long id);
    T update(T object);
}
