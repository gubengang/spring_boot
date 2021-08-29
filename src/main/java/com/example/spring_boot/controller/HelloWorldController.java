package com.example.spring_boot.controller;

import com.example.spring_boot.dao.UserRepository;
import com.example.spring_boot.model.EnumResultCode;
import com.example.spring_boot.model.Result;
import com.example.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public Result<User> insert(@Valid @RequestBody User user){
        return Result.success(userRepository.save(user));
    }
}
