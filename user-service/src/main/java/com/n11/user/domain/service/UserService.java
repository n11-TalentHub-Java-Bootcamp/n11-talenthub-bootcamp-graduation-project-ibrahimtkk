package com.n11.user.domain.service;

import com.n11.user.infrastructure.entity.User;
import com.n11.user.interfaces.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();
}
