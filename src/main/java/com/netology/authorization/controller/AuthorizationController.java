package com.netology.authorization.controller;

import com.netology.authorization.entity.Authorities;
import com.netology.authorization.exceptions.InvalidCredentials;
import com.netology.authorization.exceptions.UnauthorizedUser;
import com.netology.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AuthorizationController {
    @Autowired
    UserService service;


    @GetMapping("/authorize")
    public List<Authorities> getAutorities(@RequestParam("user") String user,
                                           @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }


    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleInvalidUser(UnauthorizedUser e) {
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
