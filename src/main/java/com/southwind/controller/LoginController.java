package com.southwind.controller;

import com.southwind.entity.Reader;
import com.southwind.entity.User;
import com.southwind.service.ReaderService;
import com.southwind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReaderService readerService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signIn")
    public String signIn(String username, String password, String type, HttpServletRequest request) {

        switch (type) {
            case "reader":
                Reader reader = readerService.getReader(password, username);
                //System.out.println(reader + "\n\n\n\n\n\n\n");
                if (reader != null) {
                    request.getSession().setAttribute("reader", reader);
                    return "redirect:/reader/allBookReader";
                }

                request.setAttribute("msg", "用户名或密码有误");
                break;
            case "admin":
                User user = userService.queryOne(username, password);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    return "redirect:/book/allBook";
                }
                request.setAttribute("msg", "用户名或密码有误");
                break;
        }
        return "login";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp";
    }


    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request) {

        User exist = userService.QueryUserByUsername(user.getUsername());
        if (exist == null) {
            userService.addUser(user);
            return "redirect:/book/allBook";
        }

        request.setAttribute("msg", "用户名已存在");
        return "signUp";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

}
