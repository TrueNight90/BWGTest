package org.yjr.init.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class defaultController {

    private Logger logger = LoggerFactory.getLogger(defaultController.class);

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("/softs")
    public String toSofts(){
        return "softs";
    }

    @RequestMapping("/random")
    public String toRandom(){
        return "random";
    }
}
