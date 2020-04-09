package com.elastic.scientificenterelastic.repository;

import com.elastic.scientificenterelastic.domain.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine,Long> {
    Magazine findByName(String name);
}
