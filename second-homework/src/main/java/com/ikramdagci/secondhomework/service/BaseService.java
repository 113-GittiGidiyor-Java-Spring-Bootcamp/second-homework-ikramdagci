package com.ikramdagci.secondhomework.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {

    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void deleteById(Long id);
    T update(T t);

}
