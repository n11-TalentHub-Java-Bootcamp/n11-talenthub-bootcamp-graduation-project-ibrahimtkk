package com.n11.user.domain.service;

import com.n11.user.infrastructure.entity.User;
import com.n11.user.infrastructure.repository.UserRepository;
import com.n11.user.interfaces.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> UserResponseDTO.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .TCKN(user.getTCKN())
                        .build())
                .collect(Collectors.toList());


    }
}
