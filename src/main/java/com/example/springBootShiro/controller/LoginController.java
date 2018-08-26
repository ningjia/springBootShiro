package com.example.springBootShiro.controller;

import com.example.springBootShiro.mapper.UserMapper;
import com.example.springBootShiro.model.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe:
 *
 * @author xxx
 * @date 2018/08/19
 */
@RestController
public class LoginController {
    @Autowired
    private ResultMap resultMap;
    @Autowired
    private UserMapper userMapper;

    /**
     * 未登录
     */
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    /**
     * 无权限
     */
    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    /**
     * 注销
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return resultMap.success().message("成功注销！");
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap login(String username, String password) {
        // 从SecurityUtils里边创建一个subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = userMapper.getRole(username);
        if ("userRole".equals(role)) {
            return resultMap.success().message("欢迎登陆！您是user权限");
        }
        if ("adminRole".equals(role)) {
            return resultMap.success().message("欢迎登陆！您是admin权限");
        }
        return resultMap.fail().message("权限错误！");
    }
}
