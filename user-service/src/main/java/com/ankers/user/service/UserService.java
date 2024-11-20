package com.ankers.user.service;

import com.ankers.user.mapper.UserMapper;
import com.ankers.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Value("${server.port}")
    private Integer port;

    public User queryById(Long id) {
        User user = userMapper.findById(id);
        user.setUsername(user.getUsername() + "=>" + port);
        return user;
    }
}