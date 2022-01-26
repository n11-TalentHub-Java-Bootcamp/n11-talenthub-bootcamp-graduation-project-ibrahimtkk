package com.n11.user.application;

import com.n11.user.domain.service.DefaultUserService;
import com.n11.user.domain.service.UserService;
import com.n11.user.infrastructure.entity.User;
import com.n11.user.interfaces.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {

        final List<UserResponseDTO> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.CREATED);
    }
}
