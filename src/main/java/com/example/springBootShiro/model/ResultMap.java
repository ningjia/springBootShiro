package com.example.springBootShiro.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * describe:用于返回操作结果的Map
 *
 * @author xxx
 * @date 2018/08/16
 */
@Component
public class ResultMap extends HashMap<String, Object>  {

    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}
