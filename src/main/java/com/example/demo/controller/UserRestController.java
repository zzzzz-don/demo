package com.example.demo.controller;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    RestService service;

    // ユーザ全件取得
    @GetMapping("/rest/get")
    public List<User> getUserMany() {
        return service.selectMany();
    }

    // ユーザ1件取得
    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        return service.selectOne(userId);
    }
}
