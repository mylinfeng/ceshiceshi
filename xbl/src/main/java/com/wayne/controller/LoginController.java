package com.wayne.controller;

import com.wayne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wayne
 * @date 2019/5/24
 */
@Controller
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private UserService userService;

    // 重定向到登录页
    @GetMapping("/login.html")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login.do")
    @ResponseBody
    public String loginDo(String username, String password) {
        return userService.login(username, password);
    }


}
