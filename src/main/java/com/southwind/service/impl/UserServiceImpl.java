package com.southwind.service.impl;

import com.southwind.entity.User;
import com.southwind.repository.UserRepository;
import com.southwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User queryOne(String username, String password) {
        return userRepository.queryOne(username, password);
    }

    @Override
    public User QueryUserByUsername(String username) {
        return userRepository.queryUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        return userRepository.addUser(user);
    }


}
