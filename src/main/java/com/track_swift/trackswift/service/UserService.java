package com.track_swift.trackswift.service;

import com.track_swift.trackswift.dto.UserRequestDto;
import com.track_swift.trackswift.dto.UserResponseDto;
import com.track_swift.trackswift.entity.User;

import java.util.List;

public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);
    public List<UserResponseDto> getUsers();
    public UserResponseDto getUser(Long id);
    public UserResponseDto updateUser(Long id,UserRequestDto userRequestDto);
    public void deleteUser(Long id);
    public User createUser(UserRequestDto userRequestDto);
    public UserResponseDto createUserResponse(User user);
}
