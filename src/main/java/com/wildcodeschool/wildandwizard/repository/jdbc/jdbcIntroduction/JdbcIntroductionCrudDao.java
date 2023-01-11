package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcIntroduction;

        import java.util.List;

public interface JdbcIntroductionCrudDao<T> {

    T save(T entity);

    T findById(Long id);

    List<T> findAll();

    T update(T entity);

    void deleteById(Long id);
}