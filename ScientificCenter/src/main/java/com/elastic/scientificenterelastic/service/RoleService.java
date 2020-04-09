package com.elastic.scientificenterelastic.service;



import com.elastic.scientificenterelastic.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRole(String roleType);
}
