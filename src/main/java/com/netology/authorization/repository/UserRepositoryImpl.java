package com.netology.authorization.repository;


import com.netology.authorization.entity.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("123")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("Ivan") && password.equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else { return Collections.EMPTY_LIST;
        }
        return authorities;
    }

}
