package com.wildcodeschool.wildandwizard.repository.jpa;

import com.wildcodeschool.wildandwizard.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaWizardRepository extends JpaRepository<Wizard, Long> {
}
