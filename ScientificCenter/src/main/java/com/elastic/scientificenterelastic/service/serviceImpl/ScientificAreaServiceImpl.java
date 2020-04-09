package com.elastic.scientificenterelastic.service.serviceImpl;

import com.elastic.scientificenterelastic.domain.Magazine;
import com.elastic.scientificenterelastic.domain.ScientificArea;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.ScientificAreaDTO;
import com.elastic.scientificenterelastic.dto.ScientificAreaListDTO;
import com.elastic.scientificenterelastic.dto.UserDTO;
import com.elastic.scientificenterelastic.dto.UserListDTO;
import com.elastic.scientificenterelastic.exception.StoreException;
import com.elastic.scientificenterelastic.globals.RoleType;
import com.elastic.scientificenterelastic.repository.MagazineRepository;
import com.elastic.scientificenterelastic.repository.ScientificAreaRepository;
import com.elastic.scientificenterelastic.repository.UserRepository;
import com.elastic.scientificenterelastic.service.ScientificAreaService;
import com.elastic.scientificenterelastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScientificAreaServiceImpl implements ScientificAreaService {

    @Autowired
    ScientificAreaRepository scientificAreaRepository;
    @Autowired
    MagazineRepository magazineRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public ScientificAreaListDTO findAllScientificArea() {
        ScientificAreaListDTO scientificAreaListDTO = new ScientificAreaListDTO();
        List<ScientificArea> scientificAreas = scientificAreaRepository.findAll();
        if(!scientificAreas.isEmpty()){
            for(ScientificArea n: scientificAreas){
                ScientificAreaDTO scientificAreaDTO = new ScientificAreaDTO(n.getScientificAreaId(),n.getName());
                scientificAreaListDTO.getScientificAreas().add(scientificAreaDTO);
            }
        }
        return scientificAreaListDTO;
    }

    @Override
    public ScientificAreaDTO getOne(Long id) {
        ScientificArea scientificArea = scientificAreaRepository.getOne(id);
        return new ScientificAreaDTO(scientificArea.getScientificAreaId(), scientificArea.getName());

    }

    @Override
    public ScientificAreaDTO addScientificArea(ScientificAreaDTO scientificAreaDTO) {
        ScientificArea scientificArea = new ScientificArea();
        scientificArea.setName(scientificAreaDTO.getName());
        scientificArea = scientificAreaRepository.save(scientificArea);
        return new ScientificAreaDTO(scientificArea.getScientificAreaId(), scientificArea.getName());
    }


    @Override
    public Boolean updateScientificArea(ScientificAreaDTO scientificAreaDTO, Long idNO) {
        ScientificArea scientificArea = scientificAreaRepository.getOne(idNO);
        if(scientificArea == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Naucna oblast ne postoji!");

        scientificArea.setName(scientificAreaDTO.getName());
        scientificAreaRepository.save(scientificArea);
        return true;

    }

    @Override
    public Boolean deleteScientificArea(Long id) {
        ScientificArea scientificArea = scientificAreaRepository.getOne(id);
        if(scientificArea ==null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Naucna oblast ne postoji!");

        scientificAreaRepository.deleteById(id);
        return true;
    }

    @Override
    public UserListDTO getUsersOfScientificAreaFromMagazine(Long idCasopisa, String roleType) {
        Magazine magazine = magazineRepository.getOne(idCasopisa);
        UserListDTO userListDTO = new UserListDTO();
        UserListDTO recenzentiDTO = userService.getAllUserByRole(roleType);
        for(UserDTO userDTO : recenzentiDTO.getUsers()){
            for (ScientificArea scientificArea : magazine.getScientificAreas()) {
                if (userDTO.getChoosenScientificAreas().stream().anyMatch(x -> x.getName().equals(scientificArea.getName()))) {
                    if(roleType.equals(RoleType.EDITOR)){
                        User user = userRepository.getOne(userDTO.getUserId());
                        if(user.getEditMagazine()==null){
                            userListDTO.getUsers().add(userDTO);
                            break;
                        }else
                            break;
                    }
                    if(roleType.equals(RoleType.REVIEWER))
                    userListDTO.getUsers().add(userDTO);

                    break;
                }
            }
        }
        return userListDTO;
    }

}
