package com.yes.dl.shop.controller.leavemessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CenterController {

    @RequestMapping("/vip.html")
    public ModelAndView jumpVip(ModelAndView modelAndView){
        modelAndView.setViewName("vip");
        return modelAndView;
    }


}
