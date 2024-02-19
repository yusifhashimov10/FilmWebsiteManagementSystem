package com.company.filmwebsitemanagementsystem.controller;

import com.company.filmwebsitemanagementsystem.model.dto.request.UserRequest;
import com.company.filmwebsitemanagementsystem.model.dto.response.UserResponse;
import com.company.filmwebsitemanagementsystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    @Operation(summary = "Create User")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    @Operation(summary = "Find User By Id")
    public ResponseEntity<UserResponse> findUserById(@PathVariable long id) {
        UserResponse response = userService.findUserById(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("all")
    @Operation(summary = "Find All Users")
    public ResponseEntity<List<UserResponse>> findAllUser() {
         List<UserResponse> all = userService.findAllUser();
        return ResponseEntity.ok(all);

    }

    @PutMapping("{id}")
    @Operation(summary = "Update User")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request,
                                                     @PathVariable long id) {
         UserResponse userResponse = userService.updateUser(id, request);
        return ResponseEntity.ok(userResponse);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
