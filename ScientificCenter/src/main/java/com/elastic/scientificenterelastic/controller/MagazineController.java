package com.elastic.scientificenterelastic.controller;

import com.elastic.scientificenterelastic.dto.AddMagazineDataDTO;
import com.elastic.scientificenterelastic.dto.AddMagazineUsersDTO;
import com.elastic.scientificenterelastic.dto.MagazineDTO;
import com.elastic.scientificenterelastic.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/magazine")
public class MagazineController {

    @Autowired
    MagazineService magazineService;

    @GetMapping
    public ResponseEntity<?> getAllNaucneCasopise(){
        return ResponseEntity.ok(magazineService.getAllMagazines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneNaucniCasopis(@PathVariable Long id){return ResponseEntity.ok(magazineService.getOneMagazine(id));}

    @GetMapping("byLeadEditor/{username}")
    public ResponseEntity<?> getCasopiseGlavnogUrednika(@PathVariable String username){
        return ResponseEntity.ok(magazineService.getMagazinesOfLeadEditor(username));
    }
    @PostMapping
    public ResponseEntity<?> addNaucniCasopisData(@RequestBody AddMagazineDataDTO addMagazineDataDTO) {
        return ResponseEntity.ok(magazineService.addMagazineData(addMagazineDataDTO));}
    @PostMapping("/addUsers")
    public ResponseEntity<?> addNaucniCasopisUsers(@RequestBody AddMagazineUsersDTO addMagazineUsersDTO){
        return ResponseEntity.ok(magazineService.addMagazineUsers(addMagazineUsersDTO));}

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNaucniCasopis(@RequestBody MagazineDTO magazineDTO, @PathVariable Long id){
        return ResponseEntity.ok(magazineService.updateMagazine(magazineDTO,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNaucniCasopis(@PathVariable Long id){
        return ResponseEntity.ok(magazineService.deleteMagazine(id));
    }

//    @PutMapping("/dopunaCasopisa")
//    public ResponseEntity<?> dopunaCasopis(@RequestBody DopunaCasopisDTO dopunaCasopisDTO){
//        return ResponseEntity.ok(camundaService.dopunaCasopisa(dopunaCasopisDTO));
//    }
//    @PutMapping("/ureduCasopis")
//    public ResponseEntity<?> ureduCasopis(@RequestBody DopunaCasopisDTO dopunaCasopisDTO){
//        return ResponseEntity.ok(camundaService.ureduCasopis(dopunaCasopisDTO));
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<?> updateCasopis(@RequestBody NaucniCasopisDTO naucniCasopisDTO){
//        return ResponseEntity.ok(camundaService.updateCasopis(naucniCasopisDTO));
//    }


}
