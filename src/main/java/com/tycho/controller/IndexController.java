package com.tycho.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Component
@Controller
public class IndexController{
    @RequestMapping(value = "/index",method= RequestMethod.GET)
    public String index(){
        return "index";
    }
}