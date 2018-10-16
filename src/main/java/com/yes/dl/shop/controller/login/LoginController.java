package com.yes.dl.shop.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login.html")
    public ModelAndView jumpLogin(ModelAndView modelAndView){
        modelAndView.setViewName("login");

        return modelAndView;
    }
}
