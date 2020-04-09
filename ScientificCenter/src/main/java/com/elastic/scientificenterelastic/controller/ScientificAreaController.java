package com.elastic.scientificenterelastic.controller;

import com.elastic.scientificenterelastic.dto.ScientificAreaDTO;
import com.elastic.scientificenterelastic.service.ScientificAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/scientificArea")
public class ScientificAreaController {

    @Autowired
    private ScientificAreaService scientificAreaService;

    @GetMapping
    public ResponseEntity<?> getAllNaucneOblasti(){
        return ResponseEntity.ok(scientificAreaService.findAllScientificArea());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneNacunaOblast(@PathVariable Long id){
        return ResponseEntity.ok(scientificAreaService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<?> addNaucnaOblast(@RequestBody ScientificAreaDTO scientificAreaDTO){
        return ResponseEntity.ok(scientificAreaService.addScientificArea(scientificAreaDTO));
    }

    @PutMapping("/{idNO}")
    public ResponseEntity<?> updateNaucnaOblast(@RequestBody ScientificAreaDTO scientificAreaDTO, @PathVariable Long idNO){
        return ResponseEntity.ok(scientificAreaService.updateScientificArea(scientificAreaDTO,idNO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNaucnaOblast(@PathVariable Long id){
        return ResponseEntity.ok(scientificAreaService.deleteScientificArea(id));
    }
    @GetMapping("/{idMagazine}/{role}")
    public ResponseEntity<?> getUsersNaucneOblasti(@PathVariable("idMagazine") Long idMagazine, @PathVariable("role") String role){
        return ResponseEntity.ok(scientificAreaService.getUsersOfScientificAreaFromMagazine(idMagazine, role));
    }
}
