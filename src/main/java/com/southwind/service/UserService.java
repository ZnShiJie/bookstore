package com.southwind.service;

import com.southwind.entity.User;

public interface UserService {
    User queryOne(String username, String password);

    User QueryUserByUsername(String username);

    int addUser(User user);
}
