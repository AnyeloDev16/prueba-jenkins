package com.skydev.pruebadocker.controller;

import com.skydev.pruebadocker.dto.UserDTO;
import com.skydev.pruebadocker.persistence.model.UserEntity;
import com.skydev.pruebadocker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserDTO userDTO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userDTO));

    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){

        return ResponseEntity.ok().body(userService.getAllUsers());

    }

}
