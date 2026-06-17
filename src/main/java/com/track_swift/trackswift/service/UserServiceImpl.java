package com.track_swift.trackswift.service;

import com.track_swift.trackswift.dto.UserRequestDto;
import com.track_swift.trackswift.dto.UserResponseDto;
import com.track_swift.trackswift.entity.User;
import com.track_swift.trackswift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = createUser(userRequestDto);
        User user1 = userRepository.save(user);
        return createUserResponse(user1);
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream().map(this::createUserResponse).toList();
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found!"));
        return createUserResponse(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not Found!"));

        user.setRole(userRequestDto.getRole());
        user.setEmail(userRequestDto.getEmail());
        user.setLastName(userRequestDto.getLastName());
        user.setFirstName(userRequestDto.getFirstName());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setPassword(userRequestDto.getPassword());

        User user1 = userRepository.save(user);
        return createUserResponse(user1);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.setRole(userRequestDto.getRole());

        return user;
    }

    @Override
    public UserResponseDto createUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber(),user.getRole());
        return userResponseDto;
    }
}
