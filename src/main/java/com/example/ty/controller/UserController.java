package com.example.ty.controller;

import com.example.ty.common.PageResult;
import com.example.ty.constant.Constant;
import com.example.ty.entity.UserEntity;
import com.example.ty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/findAll")
    public List<UserEntity> findAll(@RequestParam Map<String,Object> paraMap){
        return userService.findAll(paraMap);
    }

    @GetMapping("/page/findAll")
    public PageResult<UserEntity> findAllPage(@RequestParam("current") Integer pageNo,
                                              @RequestParam("pageSize") Integer pageSize,
                                              @RequestParam Map<String,Object> paraMap){
        Page<UserEntity> data = userService.findAllPage(paraMap,pageNo-1,pageSize);
        Long total = data.getTotalElements();
        List<UserEntity> content = data.getContent();
        log.info("content:{}",content);
        return PageResult.ok(Constant.OK,"查询成功",pageNo,pageSize,total,content);
    }
}
