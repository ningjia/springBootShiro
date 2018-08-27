package com.example.springBootShiro.mapper;

import com.example.springBootShiro.common.Constant;
import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author xxx
 * @date 2018/08/16
 */
@Component
public class UserMapper {

    /**
     * 获取用户的密码
     * @param userName
     * @return
     */
    public String getPassword(String userName){
        if(Constant.LOGIN_NAME_USER.equals(userName)){
            return Constant.LOGIN_PWD_USER;
        } else if(Constant.LOGIN_NAME_ADMIN.equals(userName)){
            return Constant.LOGIN_PWD_ADMIN;
        }
        return "";
    }

    /**
     * 获取用户的角色
     * @param userName
     * @return
     */
    public String getRole(String userName){
        if(Constant.LOGIN_NAME_USER.equals(userName)){
            return Constant.LOGIN_ROLE_USER;
        } else if(Constant.LOGIN_NAME_ADMIN.equals(userName)){
            return Constant.LOGIN_ROLE_ADMIN;
        }
        return "";
    }
}
