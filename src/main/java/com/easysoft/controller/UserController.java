package com.easysoft.controller;

import com.easysoft.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户接口", value = "该参数没什么意义，在UI界面上也看到，所以不需要配置")
@RestController
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "hello", notes = "sayHello method test.")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        log.info("这是info级别日志.");
        log.debug("这是debug级别日志.");
        return "hello";
    }

    @ApiOperation(value = "登录", notes = "根据用户名、密码登录系统")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username, String passwd) {
        boolean login = userService.login(username, passwd);
        if (login) {
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }

    @ApiOperation(value = "注册用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(String username, String passwd) {
        boolean login = userService.register(username, passwd);
        if (login) {
            return "注册成功。";
        } else {
            return "注册失败。";
        }
    }

    @ApiOperation(value = "批量注册用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/batchAdd", method = RequestMethod.GET)
    public String batchAdd(String username, String passwd) {
        userService.batchAdd(username, passwd);
        return "批量添加用户成功。";
    }


}
