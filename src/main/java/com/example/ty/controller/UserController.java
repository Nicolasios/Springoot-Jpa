package com.example.ty.controller;

import com.example.ty.entity.UserEntity;
import com.example.ty.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/findAll")
    public List<UserEntity> findAll(@RequestParam Map<String,Object> paraMap){
        return userService.findAll(paraMap);
    }
}
