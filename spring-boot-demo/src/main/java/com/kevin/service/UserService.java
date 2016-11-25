package com.kevin.service;

import com.kevin.entity.User;
import com.kevin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevin on 16/11/18.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(String name) {
        User user = new User();
        user.setName(name);
        user.setAddress("SH");
        userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
