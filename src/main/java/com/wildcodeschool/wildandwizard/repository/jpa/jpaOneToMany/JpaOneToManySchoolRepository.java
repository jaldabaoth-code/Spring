package com.wildcodeschool.wildandwizard.repository.jpa.jpaOneToMany;

import com.wildcodeschool.wildandwizard.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Quest : JPA One To Many */
@Repository
public interface JpaOneToManySchoolRepository extends JpaRepository<School, Long> {
}
