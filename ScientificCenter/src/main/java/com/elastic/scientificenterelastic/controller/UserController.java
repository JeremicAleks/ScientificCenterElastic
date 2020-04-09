package com.elastic.scientificenterelastic.controller;

import com.elastic.scientificenterelastic.dto.RegistrationDTO;
import com.elastic.scientificenterelastic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getOneUser(userId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/role/{roleName}")
    public ResponseEntity<?> getNesto(@PathVariable String roleName){
        return ResponseEntity.ok(userService.getAllUserByRole(roleName));
    }

    @GetMapping("/role/{roleName}/{scientificArea}")
    public ResponseEntity<?> getReviewerByScientificArea(@PathVariable("roleName") String rolename, @PathVariable("scientificArea") String scientificArea){
        return ResponseEntity.ok(userService.getAllUserByRoleAndScientificArea(rolename,scientificArea));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDTO registrationDTO){
        return ResponseEntity.ok(userService.registrationUser(registrationDTO));
    }

//
//    @GetMapping("/activate/{username}/{processId}")
//    public ResponseEntity<?> activateUser(@PathVariable("username") String username, @PathVariable("processId") String processId){
//        return ResponseEntity.ok(camundaService.activateUser(username,processId));
//    }
//
//    @PutMapping("/activateRecenzent")
//    public ResponseEntity<?> activateRecenzent(@RequestBody ActivateRecenzentDTO activateRecenzentDTO){
//        return ResponseEntity.ok(camundaService.activateRecenzent(activateRecenzentDTO));
//    }



}
