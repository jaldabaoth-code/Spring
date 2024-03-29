package com.wildcodeschool.wildandwizard.repository.jpa.jpaManyToMany;

import com.wildcodeschool.wildandwizard.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Quest : JPA Many To Many */
@Repository
public interface JpaManyToManyRaceRepository extends JpaRepository<Race, Long> {
}
