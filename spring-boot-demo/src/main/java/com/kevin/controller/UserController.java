package com.kevin.controller;

import com.kevin.entity.User;
import com.kevin.repository.UserRepository;
import com.kevin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kevin on 16/11/17.
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Value("${spring.datasource.name}")
    private String datasource;

    @RequestMapping("/{name}")
    public String sayHi(@PathVariable("name") String name) {
        User user = userService.findByName(name);
        String response = "Hi, " + user.getName();
        return response;
    }

    @RequestMapping("/add/{name}")
    public String addUser(@PathVariable("name") String name) {
        userService.addUser(name);
        return "添加用户成功.";
    }

    @RequestMapping("/")
    public String home() {
        return datasource;
    }
}
