package com.company.filmwebsitemanagementsystem.service;


import com.company.filmwebsitemanagementsystem.model.dto.request.UserRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.UserResponse;

import java.util.List;

public interface UserService {
   UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id, UserRequest request);

    void deleteUser(Long id);

    UserResponse findUserById(Long id);

    List<UserResponse> findAllUser();
}
