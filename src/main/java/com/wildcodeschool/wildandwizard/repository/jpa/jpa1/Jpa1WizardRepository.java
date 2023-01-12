package com.wildcodeschool.wildandwizard.repository.jpa.jpa1;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Quest : JPA 1 */
@Repository
public interface Jpa1WizardRepository extends JpaRepository<Wizard, Long> {
}
