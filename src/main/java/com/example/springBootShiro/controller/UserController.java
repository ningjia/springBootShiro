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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ResultMap resultMap;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap getMessage() {
        return resultMap.success().message("您拥有User权限，可以获得该接口的信息！");
    }
}
