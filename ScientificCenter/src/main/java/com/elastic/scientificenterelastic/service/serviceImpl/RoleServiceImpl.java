package com.elastic.scientificenterelastic.service.serviceImpl;

import com.elastic.scientificenterelastic.domain.Role;
import com.elastic.scientificenterelastic.repository.RoleRepository;
import com.elastic.scientificenterelastic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRole(String roleType) {
        return roleRepository.findByName(roleType);
    }
}
