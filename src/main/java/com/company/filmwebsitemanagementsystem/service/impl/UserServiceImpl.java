package com.company.filmwebsitemanagementsystem.service.impl;

import com.company.filmwebsitemanagementsystem.mapper.UserMapper;
import com.company.filmwebsitemanagementsystem.model.dto.request.UserRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.UserResponse;
import com.company.filmwebsitemanagementsystem.model.entity.User;
import com.company.filmwebsitemanagementsystem.model.enums.Exceptions;
import com.company.filmwebsitemanagementsystem.model.exception.ApplicationException;
import com.company.filmwebsitemanagementsystem.repository.UserRepository;
import com.company.filmwebsitemanagementsystem.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.mapToUserFromUserRequest(request);
        User savedUser = userRepository.save(user);
        log.info("User created successfully!");
        UserResponse userResponse = userMapper.mapToUserResponseFromUser(savedUser);

        return userResponse;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND));

        User updatedUser = userMapper.mapForUpdate(user, request);

        User savedUser = userRepository.save(updatedUser);
        return userMapper.mapToUserResponseFromUser(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public UserResponse findUserById(Long id) {
       User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND));
        UserResponse userResponse = userMapper.mapToUserResponseFromUser(user);
        return userResponse;
    }

    @Override
    public List<UserResponse> findAllUser() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream()
                .map(userMapper::mapToUserResponseFromUser)
                .collect(Collectors.toList());
    }
}
