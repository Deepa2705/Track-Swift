package com.track_swift.trackswift.controller;

import com.track_swift.trackswift.dto.UserRequestDto;
import com.track_swift.trackswift.dto.UserResponseDto;
import com.track_swift.trackswift.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addUser(userRequestDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable Long id,@RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }
}
