package com.elastic.scientificenterelastic.service;


import com.elastic.scientificenterelastic.dto.ScientificAreaDTO;
import com.elastic.scientificenterelastic.dto.ScientificAreaListDTO;
import com.elastic.scientificenterelastic.dto.UserListDTO;

public interface ScientificAreaService {

    ScientificAreaListDTO findAllScientificArea();
    ScientificAreaDTO getOne(Long id);
    ScientificAreaDTO addScientificArea(ScientificAreaDTO scientificAreaDTO);
    Boolean updateScientificArea(ScientificAreaDTO scientificAreaDTO, Long idNO);
    Boolean deleteScientificArea(Long id);
    UserListDTO getUsersOfScientificAreaFromMagazine(Long idMagazine, String RoleType);

//    List<String> getOblastiName();
}
