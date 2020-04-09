package com.elastic.scientificenterelastic.service;


import com.elastic.scientificenterelastic.dto.*;

public interface MagazineService {
    MagazineListDTO getAllMagazines();
    MagazineDTO getOneMagazine(Long id);
    MagazineDTO findByName(String name);
    MagazineDTO addMagazineData(AddMagazineDataDTO addMagazineDataDTO);
    MagazineDTO addMagazineUsers(AddMagazineUsersDTO addMagazineUsersDTO);
    Boolean addMagazine(MagazineDTO magazineDTO);
    Boolean updateMagazine(MagazineDTO magazineDTO, Long id);
    Boolean deleteMagazine(Long id);
    MagazineDTO activateMagazine(EditMagazineDTO editMagazineDTO);
    MagazineListDTO getMagazinesOfLeadEditor(String username);
    MagazineDTO updateMagazine(MagazineDTO magazineDTO);
}
