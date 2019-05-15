package com.tycho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tycho.test.TestDynamicDataSourceDao;


@Component
@Controller
public class IndexController{
	
	@Autowired
    private TestDynamicDataSourceDao dao;
	
	
    @RequestMapping(value = "/index",method= RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        String dataSource1Name = dao.getDataSource1Name();
        String dataSource2Name = dao.getDataSource2Name();
        System.out.println(dataSource1Name);
        System.out.println(dataSource2Name);
        String res = "{'before':"+dataSource1Name+",'later':"+dataSource2Name+"}";
        return res;
    }
}