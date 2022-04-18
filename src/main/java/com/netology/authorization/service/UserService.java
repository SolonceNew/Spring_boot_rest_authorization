package com.netology.authorization.service;


import com.netology.authorization.entity.Authorities;

import java.util.List;


public interface UserService {

    List<Authorities> getAuthorities(String userName, String password);


}
