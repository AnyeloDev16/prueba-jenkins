package com.skydev.pruebadocker.service;

import com.skydev.pruebadocker.dto.UserDTO;
import com.skydev.pruebadocker.persistence.model.UserEntity;
import com.skydev.pruebadocker.persistence.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public UserEntity createUser(UserDTO userDTO) {

        return userRepository.save(UserEntity.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build());

    }

    public List<UserEntity> getAllUsers() {

        return userRepository.findAll();

    }

}