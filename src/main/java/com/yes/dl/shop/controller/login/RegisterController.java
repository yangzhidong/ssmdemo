package com.yes.dl.shop.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class RegisterController {

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public ModelAndView jumpRegister(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
