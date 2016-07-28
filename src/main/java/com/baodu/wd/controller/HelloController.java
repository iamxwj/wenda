package com.baodu.wd.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhipeng
 * @date 2016/7/28.
 */
@Controller
@RequestMapping(name = "/hello")
public class HelloController {
    @RequestMapping(name = "/hello")
    @ResponseBody
    public String hello(){
        return "hello world!";
    }
}
