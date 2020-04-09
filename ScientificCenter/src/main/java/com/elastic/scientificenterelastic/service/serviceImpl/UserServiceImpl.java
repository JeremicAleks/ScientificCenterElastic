package com.elastic.scientificenterelastic.service.serviceImpl;

import com.elastic.scientificenterelastic.domain.Role;
import com.elastic.scientificenterelastic.domain.ScientificArea;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.RegistrationDTO;
import com.elastic.scientificenterelastic.dto.ScientificAreaDTO;
import com.elastic.scientificenterelastic.dto.UserDTO;
import com.elastic.scientificenterelastic.dto.UserListDTO;
import com.elastic.scientificenterelastic.exception.StoreException;
import com.elastic.scientificenterelastic.globals.RoleType;
import com.elastic.scientificenterelastic.mapper.UserMapper;
import com.elastic.scientificenterelastic.repository.ScientificAreaRepository;
import com.elastic.scientificenterelastic.repository.UserRepository;
import com.elastic.scientificenterelastic.service.RoleService;
import com.elastic.scientificenterelastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    ScientificAreaRepository scientificAreaRepository;

    @Override
    public UserListDTO getAllUsers() {
        UserListDTO userListDTO = new UserListDTO();
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            for(User user: users){
                userListDTO.getUsers().add(userMapper.map(user));
            }
        }else
            throw new StoreException(HttpStatus.NOT_FOUND,"Ne postoji ni jedan korisnik!");

        return userListDTO;
    }

    @Override
    public UserDTO getOneUser(Long id) {
        User user = userRepository.getOne(id);
        if(user == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Korisnik ne postoji!");
        return userMapper.map(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Korisnik sa tim username - mom ne postoji!");

        return userMapper.map(user);
    }

    @Override
    public UserListDTO getAllUserByRole(String roleType) {
        UserListDTO userListDTO = new UserListDTO();
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getRoles().stream().anyMatch(x->x.getName().equals(roleType)))
                userListDTO.getUsers().add(userMapper.map(user));
        }

        return userListDTO;
    }

    @Override
    public UserDTO registrationUser(RegistrationDTO registrationDTO) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setCity(registrationDTO.getCity());
        user.setCountry(registrationDTO.getCountry());
        user.setEmail(registrationDTO.getEmail());
        user.setUsername(registrationDTO.getUsername());
        user.setFirstname(registrationDTO.getFirstname());
        user.setReviewerCheck(registrationDTO.getReviewerCheck());
        user.setActive(registrationDTO.getActive());
        user.setSurname(registrationDTO.getSurname());
        user.setPassword("{bcrypt}"+ passwordEncoder.encode(registrationDTO.getPassword()));
        user.setTitle(registrationDTO.getTitle());

        List<Long> naucneOblastiIds = registrationDTO.getScientificAreasIds();
        Set<ScientificArea> scientificAreas = new HashSet<>();
        for(Long id : naucneOblastiIds){
            ScientificArea scientificArea = scientificAreaRepository.getOne(id);
            scientificAreas.add(scientificArea);
        }
        user.setChoosenScientificAreas(scientificAreas);
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findRole(RoleType.USER);
        roles.add(role);
        user.setRoles(roles);
        user = userRepository.save(user);
        UserDTO userDTO = userMapper.map(user);

        return userDTO;
    }

    @Override
    public UserListDTO getAllUserByRoleAndScientificArea(String rolename, String scientificArea) {
        UserListDTO userListDTO = getAllUserByRole(rolename);
        UserListDTO users = new UserListDTO();
        for(UserDTO userDTO : userListDTO.getUsers()){
            for(ScientificAreaDTO scientificAreaDTO : userDTO.getChoosenScientificAreas()){
                if(scientificAreaDTO.getName().equalsIgnoreCase(scientificArea)){
                    users.getUsers().add(userDTO);
                    break;
                }
            }
        }
        return users;
    }

//    @Override
//    public UserDTO activateUser(String username) {
//        User user = userRepository.findByUsername(username);
//        if(user==null)
//            throw new StoreException(HttpStatus.BAD_REQUEST,"Korisnik sa ovim username-mom ne postoji");
//
//        user.setAktivan(true);
//        user = userRepository.save(user);
//        return userMapper.map(user);
//    }
//
//    @Override
//    public UserDTO activateRecenzent(ActivateRecenzentDTO activateRecenzentDTO) {
//        User user = userRepository.getOne(activateRecenzentDTO.getUserId());
//        if(user==null)
//            throw new StoreException(HttpStatus.BAD_REQUEST,"Korisnik sa ovim id-jem ne postoji");
//        user.setRecenzentCheck(false);
//        if(activateRecenzentDTO.isActivate()){
//            Set<Role> roles = new HashSet<>();
//            Role role = roleService.findRole(RoleType.REVIEWER);
//            roles.add(role);
//            user.setRoles(roles);
//        }
//        user = userRepository.save(user);
//        return userMapper.map(user);
//    }


}
