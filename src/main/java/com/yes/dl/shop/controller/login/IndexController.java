package com.yes.dl.shop.controller.login;

import com.yes.dl.shop.db.domain.VO.FirstModule;
import com.yes.dl.shop.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = {"/index.html", "/"})
    public ModelAndView jumpIndex(ModelAndView modelAndView){
        List<FirstModule> firstAndSecondModule = indexService.findFirstAndSecondModule();

        modelAndView.setViewName("forward:/index.jsp");
        modelAndView.addObject("firstAndSecondModule",firstAndSecondModule);
        return modelAndView;
    }
}
