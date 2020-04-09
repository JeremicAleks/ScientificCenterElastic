package com.elastic.scientificenterelastic.service;


import com.elastic.scientificenterelastic.dto.RegistrationDTO;
import com.elastic.scientificenterelastic.dto.UserDTO;
import com.elastic.scientificenterelastic.dto.UserListDTO;

public interface UserService {

    UserListDTO getAllUsers();
    UserDTO getOneUser(Long id);
    UserDTO getUserByUsername(String username);
    UserListDTO getAllUserByRole(String roleType);
    UserDTO registrationUser(RegistrationDTO registrationDTO);

    UserListDTO getAllUserByRoleAndScientificArea(String rolename, String scientificArea);
//    UserDTO activateUser(String username);
//    UserDTO activateRecenzent(ActivateRecenzentDTO activateRecenzentDTO);
}
