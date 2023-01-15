package com.wildcodeschool.wildandwizard.repository.injection.injection1;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import java.util.List;

/* Quest : Injection 1 */
public interface Injection1WizardDao {
    Wizard save(Wizard entity);

    Wizard findById(Long id);

    List<Wizard> findAll();

    Wizard update(Wizard entity);

    void deleteById(Long id);
}
