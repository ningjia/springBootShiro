package com.example.springBootShiro.mapper;

import org.springframework.stereotype.Component;

/**
 * describe:
 *
 * @author xxx
 * @date 2018/08/16
 */
@Component
public class UserMapper {

    public String getPassword(String userName){
        if(userName.equals("user")){
            return "userPwd";
        } else if(userName.equals("admin")){
            return "adminPwd";
        }
        return "";
    }

    public String getRole(String userName){
        if(userName.equals("user")){
            return "userRole";
        } else if(userName.equals("admin")){
            return "adminRole";
        }
        return "";
    }
}
