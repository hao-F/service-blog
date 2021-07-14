package com.fan.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fan.respond.Result;
import com.fan.system.entity.User;
import com.fan.system.mapper.UserMapper;
import com.fan.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fan
 * @since 2021-03-10
 */
@Api(value = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", user.getUsername());
        User oneUser = userService.getOne(queryWrapper);
        if(oneUser != null) {
            if (oneUser.getPassword().equals(user.getPassword())) {
                return Result.ok().data("user", oneUser);
            } else {
                return Result.error("密码输入有误");
            }
        } else {
            return Result.error("用户名不存在");
        }
    }
}

