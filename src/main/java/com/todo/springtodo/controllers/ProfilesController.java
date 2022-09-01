package com.todo.springtodo.controllers;

import com.todo.springtodo.dto.ProfileDTO;
import com.todo.springtodo.entities.Profile;
import com.todo.springtodo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public HttpStatus addProfile(@RequestBody Profile profile){
        profileService.addProfile(profile);
        return HttpStatus.OK;
    }

    @GetMapping("/get")
    public ResponseEntity<?>getAllProfiles(){
        return new ResponseEntity<>(profileService.getAllProfiles(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ProfileDTO getProfileById(@PathVariable("id") Long id){
        return profileService.getById(id);
    }
}
