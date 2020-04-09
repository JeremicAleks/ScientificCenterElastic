package com.elastic.scientificenterelastic.repository;

import com.elastic.scientificenterelastic.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
