package com.hoteltest.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void delete(T t);
    void deleteById(Long id);
}