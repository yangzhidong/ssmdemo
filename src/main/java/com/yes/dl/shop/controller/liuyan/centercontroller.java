package com.yes.dl.shop.controller.liuyan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class centercontroller {
    @RequestMapping("/vip.html")
    public ModelAndView jumpVip(ModelAndView modelAndView){
        modelAndView.setViewName("vip");
        return modelAndView;
    }


}
