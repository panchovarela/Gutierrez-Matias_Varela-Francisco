package com.company.dao;

import java.util.List;

public interface DAO<T> {

    T save(T t);
    T search(Long id);
    void delete(Long id);
    List<T> searchAll();
}
