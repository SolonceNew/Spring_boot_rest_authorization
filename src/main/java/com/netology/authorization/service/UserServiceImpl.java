package com.netology.authorization.service;


import com.netology.authorization.entity.Authorities;
import com.netology.authorization.exceptions.InvalidCredentials;
import com.netology.authorization.exceptions.UnauthorizedUser;
import com.netology.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Authorities> getAuthorities(String userName, String password) {
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("user or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("unknown user" + userName);
        }
        return userAuthorities;
    }


    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }


    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
