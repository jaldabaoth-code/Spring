package com.wildcodeschool.wildandwizard.repository.jpa;

import com.wildcodeschool.wildandwizard.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRaceRepository extends JpaRepository<Race, Long> {
}
