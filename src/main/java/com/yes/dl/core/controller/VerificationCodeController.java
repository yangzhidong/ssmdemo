package com.yes.dl.core.controller;

import com.yes.dl.core.framework.servlet.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class VerificationCodeController {

    @Autowired
    private VerificationCode verificationCode;

    @RequestMapping(value = "/getVerificationCodeImage", method = RequestMethod.GET)
    public @ResponseBody void getVerificationCode(HttpSession session, HttpServletResponse response) throws IOException {
        verificationCode.service(session, response);
    }
}
