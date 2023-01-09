package com.wildcodeschool.wildandwizard.repository.jpa.jpaOneToMany;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOneToManyWizardRepository extends JpaRepository<Wizard, Long> {
}
