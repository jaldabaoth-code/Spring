package com.wildcodeschool.wildandwizard.repository.jpa.jpa1;

import com.wildcodeschool.wildandwizard.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jpa1SchoolRepository extends JpaRepository<School, Long> {
}
