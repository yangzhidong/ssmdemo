package com.yes.dl.shop.controller.leavemessage;

import com.yes.dl.shop.db.domain.Message;
import com.yes.dl.shop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveMessageController {

    @Autowired
    private TestService testService;
//点击在线留言
    @RequestMapping("/message.html")
    public ModelAndView jumpMessage(ModelAndView modelAndView){
        modelAndView.setViewName("message");
        return modelAndView;
    }
    //留言提交
    @RequestMapping("/insertMessage.html")
    public String insertMessage(Message message, HttpServletRequest request, HttpServletResponse response) {
//之后修改与登陆的用户名一致
        List<Map<String, Object>> maps = testService.queryPersons();
        for (int i = 0;i < maps.size(); i++){
          if (maps.get(i).get("username").equals(message.getUserName())){
                request.setAttribute("messageinfo","留言成功！");
                testService.insertMessage(message);
                return ("forward:/message.html");
          }
       }
        request.setAttribute("messageinfo","用户名错误，留言失败！");
        return ("forward:/message.html");
    }
}
