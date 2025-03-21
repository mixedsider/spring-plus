package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable(name = "userId") long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/users")
    public void changePassword(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        userService.changePassword(authUser.getId(), userChangePasswordRequest);
    }

    @PutMapping("/users/images")
    public ResponseEntity<Void> uploadFile(
            @AuthenticationPrincipal AuthUser authUser,
            @RequestParam(name = "file") MultipartFile file
    ) {
        userService.updateProfileImage(authUser.getId(), file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/images")
    public ResponseEntity<Void> deleteFile(
            @AuthenticationPrincipal AuthUser authUser
    ) {
        userService.deleteProfileImage(authUser.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/users/jpa")
    public ResponseEntity<Void> findUserNameWithJpa(@RequestParam(name = "name") String name) {
        userService.findUserNameWithJpa(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/querydsl")
    public ResponseEntity<Void> findUserNameWithQuerydsl(@RequestParam(name = "name") String name) {
        userService.findUserNameWithQuerydsl(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/index/jpa")
    public ResponseEntity<Void> findUserNameWithJpaIndex(@RequestParam(name = "name") String name) {
        userService.findUserNameWithJpaIndex(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/index/querydsl")
    public ResponseEntity<Void> findUserNameWithQuerydslIndex(@RequestParam(name = "name") String name) {
        userService.findUserNameWithQuerydslIndex(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
