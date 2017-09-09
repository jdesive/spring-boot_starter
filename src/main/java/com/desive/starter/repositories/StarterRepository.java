package com.desive.starter.repositories;

import com.desive.starter.entities.StarterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarterRepository extends JpaRepository<StarterEntity, Long> {
}
