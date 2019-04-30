package com.mrbird.api.demoRestful;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * 用于测试的接口。
 * 这里使用了标准的restful接口风格，swagger自动API接口，
 * shiro 接口权限注解@RequiresPermissions组合成的一个controller。
 * 当然也可以使用其他技术，只要能获取到接口信息就行。
 *
 * @Description
 * @Author: liucq
 * @Date: 2019/4/30
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", tags = {"用户管理"})
public class UserController {

    @GetMapping
    @ApiOperation("获取列表")
    @RequiresPermissions("user:list")
    public void list() {
        System.out.println();
    }


    @GetMapping(path = "/{userId}")
    @ApiOperation("获取详情")
    @RequiresPermissions("user:get")
    public void getUserById(@PathVariable("userId") String userId) {
        System.out.println();
    }

    @PostMapping
    @ApiOperation("新增一个用户")
    @RequiresPermissions("user:save")
    public void save() {
        System.out.println();
    }

    @PutMapping("/{userId}")
    @ApiOperation("修改保存")
    @RequiresPermissions("user:update")
    public void editSave(@PathVariable String userId) {
        System.out.println();
    }

}
