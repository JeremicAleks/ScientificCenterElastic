package com.elastic.scientificenterelastic.service.serviceImpl;

import com.elastic.scientificenterelastic.domain.Magazine;
import com.elastic.scientificenterelastic.domain.Role;
import com.elastic.scientificenterelastic.domain.ScientificArea;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.*;
import com.elastic.scientificenterelastic.exception.StoreException;
import com.elastic.scientificenterelastic.globals.RoleType;
import com.elastic.scientificenterelastic.mapper.MagazineMapper;
import com.elastic.scientificenterelastic.repository.MagazineRepository;
import com.elastic.scientificenterelastic.repository.ScientificAreaRepository;
import com.elastic.scientificenterelastic.repository.UserRepository;
import com.elastic.scientificenterelastic.service.MagazineService;
import com.elastic.scientificenterelastic.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    MagazineRepository magazineRepository;
    @Autowired
    MagazineMapper magazineMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ScientificAreaRepository scientificAreaRepository;
    @Autowired
    RoleService roleService;

    @Override
    public MagazineListDTO getAllMagazines() {
        MagazineListDTO magazineListDTO = new MagazineListDTO();
        List<Magazine> magazine = magazineRepository.findAll();
        if (!magazine.isEmpty()){
            for(Magazine mag : magazine){
                magazineListDTO.getMagazines().add(magazineMapper.map(mag));
            }
        }
        return magazineListDTO;
    }

    @Override
    public MagazineDTO getOneMagazine(Long id) {
        Magazine magazine = magazineRepository.getOne(id);
        if(magazine !=null)
            return magazineMapper.map(magazine);
        else
            throw new StoreException(HttpStatus.NOT_FOUND,"Magazine doesn't exist");
    }

    @Override
    public MagazineDTO findByName(String name) {
        Magazine magazine = magazineRepository.findByName(name);
        if (magazine !=null){
            return magazineMapper.map(magazine);
        }else{
            return null;
        }
    }

    @Override
    public MagazineDTO addMagazineData(AddMagazineDataDTO addMagazineDataDTO) {
        Magazine magazine = new Magazine();
        magazine.setMagazineType(addMagazineDataDTO.getMagazineType());
        magazine.setPrice(addMagazineDataDTO.getPrice());
        magazine.setActiveStatus(addMagazineDataDTO.isActiveStatus());
        magazine.setiSSN(addMagazineDataDTO.getiSSN());
        magazine.setName(addMagazineDataDTO.getName());
        User leadEditor = userRepository.findByUsername(addMagazineDataDTO.getLeadEditorUsername());
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findRole(RoleType.LEADEDITOR);
        roles.add(role);
        leadEditor.setRoles(roles);

        magazine.setLeadEditor(leadEditor);

        Set<ScientificArea> scientificAreas = new HashSet<>();
        for(Long id : addMagazineDataDTO.getScientificAreaIds()){
            ScientificArea scientificArea = scientificAreaRepository.getOne(id);
            scientificAreas.add(scientificArea);
        }

        magazine.setScientificAreas(scientificAreas);
        magazine = magazineRepository.save(magazine);

        Set<Magazine> magazineLeadEditor = leadEditor.getMagazineSet();
        if(magazineLeadEditor == null)
            magazineLeadEditor = new HashSet<>();

        magazineLeadEditor.add(magazine);
        leadEditor.setMagazineSet(magazineLeadEditor);
        userRepository.save(leadEditor);

        return magazineMapper.map(magazine);
    }

    @Override
    public MagazineDTO addMagazineUsers(AddMagazineUsersDTO addMagazineUsersDTO) {
        Magazine magazine = magazineRepository.getOne(addMagazineUsersDTO.getId());

        Set<User> editors= new HashSet<>();
        for(Long id: addMagazineUsersDTO.getEditorsIds()){
            User user = userRepository.getOne(id);
            user.setEditMagazine(magazine);
            userRepository.save(user);
            editors.add(user);
        }
        magazine.setEditors(editors);
        Set<User> recenzenti = new HashSet<>();
        for(Long id: addMagazineUsersDTO.getReviewersIds()){
            User user = userRepository.getOne(id);
            recenzenti.add(user);
        }
        magazine.setReviewers(recenzenti);
        magazine = magazineRepository.save(magazine);
        return magazineMapper.map(magazine);
    }

    @Override
    public Boolean addMagazine(MagazineDTO casopisDTO) {
        Magazine magazine = new Magazine();
        magazine.setMagazineType(casopisDTO.getMagazineType());
        magazine.setPrice(casopisDTO.getPrice());
        magazine.setiSSN(casopisDTO.getiSSN());
        magazine.setName(casopisDTO.getName());

        User leadEditor = userRepository.getOne(casopisDTO.getLeadEditor().getUserId());
        if(leadEditor == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Lead Editor doesn't exist");



        magazine.setLeadEditor(leadEditor);

        //STAVITII DA DTO IMA SAMO ID-jeve ne ceo set
        Set<ScientificArea> scientificAreaSet = new HashSet<>();
        for(ScientificAreaDTO oblastDTO: casopisDTO.getScientificAreas()){
            ScientificArea scientificArea = scientificAreaRepository.getOne(oblastDTO.getScientificAreaId());
            if(scientificArea == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Scientific Area doesn't exist");
            scientificAreaSet.add(scientificArea);
        }
        magazine.setScientificAreas(scientificAreaSet);

        Set<User> recenzenti = new HashSet<>();
        for(UserDTO userDTO: casopisDTO.getReviewers()){
            User recenzent = userRepository.getOne(userDTO.getUserId());
            if(recenzent == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Reviewer doesn't exist");
            recenzenti.add(recenzent);
        }
        magazine.setReviewers(recenzenti);

        Set<User> editors = new HashSet<>();
        for(UserDTO userDTO: casopisDTO.getEditors()){
            User editor = userRepository.getOne(userDTO.getUserId());
            if(editor == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Edtor doesn't exist");
            editors.add(editor);
        }
        magazine.setEditors(editors);

        magazine = magazineRepository.save(magazine);

        Set<Magazine> magazineLeadEditor = leadEditor.getMagazineSet();
        if(magazineLeadEditor == null)
            magazineLeadEditor = new HashSet<>();

        magazineLeadEditor.add(magazine);
        leadEditor.setMagazineSet(magazineLeadEditor);
        userRepository.save(leadEditor);


        return true;
    }

    @Override
    public Boolean updateMagazine(MagazineDTO casopisDTO, Long id) {
        Magazine magazine = magazineRepository.getOne(id);
        if(magazine == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Naucni casopis ne postoji");
        magazine.setMagazineType(casopisDTO.getMagazineType());
        magazine.setPrice(casopisDTO.getPrice());
        magazine.setiSSN(casopisDTO.getiSSN());
        magazine.setName(casopisDTO.getName());


        //STAVITII DA DTO IMA SAMO ID-jeve ne ceo set
        Set<ScientificArea> scientificAreaSet = new HashSet<>();
        for(ScientificAreaDTO oblastDTO: casopisDTO.getScientificAreas()){
            ScientificArea scientificArea = scientificAreaRepository.getOne(oblastDTO.getScientificAreaId());
            if(scientificArea == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Scientific Area doesn't exist");
            scientificAreaSet.add(scientificArea);
        }
        magazine.setScientificAreas(scientificAreaSet);

        Set<User> recenzenti = new HashSet<>();
        for(UserDTO userDTO: casopisDTO.getReviewers()){
            User recenzent = userRepository.getOne(userDTO.getUserId());
            if(recenzent == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Reviewer doesn't exist");
            recenzenti.add(recenzent);
        }
        magazine.setReviewers(recenzenti);

        Set<User> editors = new HashSet<>();
        for(UserDTO userDTO: casopisDTO.getEditors()){
            User editor = userRepository.getOne(userDTO.getUserId());
            if(editor == null)
                throw new StoreException(HttpStatus.NOT_FOUND,"Editor doesn't exist");
            editors.add(editor);
        }
        magazine.setEditors(editors);

        magazineRepository.save(magazine);


        return true;
    }

    @Override
    public Boolean deleteMagazine(Long id) {
        Magazine magazine = magazineRepository.getOne(id);
        if (magazine == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Magazine doesn't exist");
        magazineRepository.delete(magazine);
        return true;
    }

    @Override
    public MagazineDTO activateMagazine(EditMagazineDTO editMagazineDTO) {
        Magazine magazine = magazineRepository.getOne(editMagazineDTO.getId());
        magazine.setActiveStatus(true);
        magazine.setNeedEdit(editMagazineDTO.isActivate());
        magazine = magazineRepository.save(magazine);
        return magazineMapper.map(magazine);
    }

    @Override
    public MagazineListDTO getMagazinesOfLeadEditor(String username) {
        User user = userRepository.findByUsername(username);
        MagazineListDTO magazineListDTO = new MagazineListDTO();
        Set<Magazine> naucniCasopis = user.getMagazineSet();
        for(Magazine nc : naucniCasopis)
            magazineListDTO.getMagazines().add(magazineMapper.map(nc));

        return magazineListDTO;
    }
    @Override
    public MagazineDTO updateMagazine(MagazineDTO magazineDTO) {
        Magazine magazine = magazineRepository.getOne(magazineDTO.getMagazineId());
        magazine.setName(magazineDTO.getName());
        magazine.setiSSN(magazineDTO.getiSSN());
        magazine.setPrice(magazineDTO.getPrice());
        magazine.setMagazineType(magazineDTO.getMagazineType());
        Set<ScientificArea> oblasts = new HashSet<>();
        for(ScientificAreaDTO scientificAreaDTO : magazineDTO.getScientificAreas()){
            ScientificArea scientificArea = scientificAreaRepository.getOne(scientificAreaDTO.getScientificAreaId());
            oblasts.add(scientificArea);
        }
        magazine.setScientificAreas(oblasts);
        magazine = magazineRepository.save(magazine);
        return magazineMapper.map(magazine);
    }
}
