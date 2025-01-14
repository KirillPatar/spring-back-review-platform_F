package com.hermanvfx.springbackreviewplatform.controller;

import com.example.userservice.controller.UserApi;
import com.example.userservice.dto.ShortUserDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.dto.UserListDto;
import com.hermanvfx.springbackreviewplatform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(ShortUserDto shortUserDto) {
        UserDto newUser = userService.create(shortUserDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserListDto> findAllUsers(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>( userService.findAllUser(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> findUsersById(UUID userId) {
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UUID userId, UserDto userDto) {
        return null;
    }
}
