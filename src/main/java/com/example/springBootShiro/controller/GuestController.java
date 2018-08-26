package com.example.springBootShiro.controller;

import com.example.springBootShiro.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe:
 *
 * @author xxx
 * @date 2018/08/16
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private ResultMap resultMap;

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ResultMap login() {
        return resultMap.success().message("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap submitLogin() {
        return resultMap.success().message("您拥有游客的权限，可以获得该接口的信息！");
    }
}
