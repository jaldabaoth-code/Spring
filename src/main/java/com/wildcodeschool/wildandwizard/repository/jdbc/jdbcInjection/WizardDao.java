package com.wildcodeschool.wildandwizard.repository.jdbc.jdbcInjection;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import java.util.List;

/* Quest : JDBC Injection */
public interface WizardDao {
    Wizard save(Wizard entity);

    Wizard findById(Long id);

    List<Wizard> findAll();

    Wizard update(Wizard entity);

    void deleteById(Long id);
}
