package org.yjr.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/loginPage")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("/access/error")
    public String toError(){
        return "error";
    }

    @RequestMapping("/logout")
    public String toLogout(HttpServletRequest request){
        request.getSession().invalidate();
        return "loginPage";
    }
}
