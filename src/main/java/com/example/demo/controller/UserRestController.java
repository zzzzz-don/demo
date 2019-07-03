package com.example.demo.controller;

import com.example.demo.domain.model.User;
import com.example.demo.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // ユーザを1件登録
    @PostMapping("/rest/insert")
    public String postUserOne(@RequestBody User user) {
        boolean result = service.insert(user);
        String str = "";
        if (result == true) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
}
