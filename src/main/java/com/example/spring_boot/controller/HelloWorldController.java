package com.example.spring_boot.controller;

import com.example.spring_boot.dao.UserRepository;
import com.example.spring_boot.model.EnumResultCode;
import com.example.spring_boot.model.Result;
import com.example.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gubengang
 * @create 2021-08-15 10:22
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public Result<List<User>> list(){
        List<User> list = userRepository.findAll();
        return Result.success(list);
    }

    @GetMapping("/success")
    public Result<Void> success(){
        return Result.success();
    }

    @GetMapping("/failure")
    public Result<Void> failure(){
        return Result.failure("测试自定义失败信息");
    }

    @GetMapping("/failure1")
    public Result<Void> failure1(){
        return Result.failure(EnumResultCode.REQUEST_PARAM_ERROR);
    }

    @RequestMapping("/insert")
    public Result<User> insert(@RequestBody @Validated User user){
        return Result.success(userRepository.save(user));
    }
}
