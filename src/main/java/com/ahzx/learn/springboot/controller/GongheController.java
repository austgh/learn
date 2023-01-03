package com.ahzx.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author think
 * @version 1.0
 * @date 2022/3/18 6:43
 */
@Controller
public class GongheController {
    @RequestMapping("/test1")
    public String test() {
        System.out.println("hello");
        return "hello";
    }
}
