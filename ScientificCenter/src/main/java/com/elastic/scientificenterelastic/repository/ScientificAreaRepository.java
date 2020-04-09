package com.elastic.scientificenterelastic.repository;


import com.elastic.scientificenterelastic.domain.ScientificArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScientificAreaRepository extends JpaRepository<ScientificArea,Long> {
    ScientificArea findByName(String name);
}
