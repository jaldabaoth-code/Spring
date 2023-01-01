package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
