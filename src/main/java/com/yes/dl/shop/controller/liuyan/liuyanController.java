package com.yes.dl.shop.controller.liuyan;

import com.yes.dl.shop.db.domain.Message;
import com.yes.dl.shop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class liuyanController {
    @Autowired
    private TestService testService;
    @RequestMapping("/message.html")
    public ModelAndView jumpMessage(ModelAndView modelAndView){
        modelAndView.setViewName("message");
        return modelAndView;
    }
    @RequestMapping("/insertMessage.html")
    public String insertMessage(Message message, HttpServletRequest httpServletRequest) {

        List<Map<String, Object>> maps = testService.queryPersons();
        for (int i = 0;i < maps.size(); i++){
          if (maps.get(i).get("username").equals(message.getUserName())){
                httpServletRequest.setAttribute("messageinfo","成功");
              testService.insertMessage(message);
              return ("redirect:/message.html");
          }
       }
        return ("redirect:/message.html");
    }
}
