package com.wildcodeschool.wildandwizard.repository.jdbc.jdbc1;

import java.util.List;

public interface Jdbc1GithuberDao<T> {
    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Long id);


}
