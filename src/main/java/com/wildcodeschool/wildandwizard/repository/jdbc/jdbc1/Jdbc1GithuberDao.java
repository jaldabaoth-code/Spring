package com.wildcodeschool.wildandwizard.repository.jdbc.jdbc1;

import java.util.List;

/* Quest : JDBC 1 */
public interface Jdbc1GithuberDao<T> {
    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Long id);
}
