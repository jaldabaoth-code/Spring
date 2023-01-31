package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcCrud;

import java.util.List;

public interface JdbcCrudCrudDao<T> {

    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Long id);
}