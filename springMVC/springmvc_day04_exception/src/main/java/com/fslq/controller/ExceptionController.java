package com.fslq.controller;

import com.fslq.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 异常实体类
* */
@Controller
@RequestMapping("exception")
public class ExceptionController {
    //数字处理异常
    @RequestMapping("numberException")
    public String numberException() throws SysException{
        int i=10;
        try{
            i=i/0;
        }catch(Exception e){
            e.printStackTrace();
            //自定义抛出异常
            throw new SysException( "被除数为零！" );
        }
        return "success";
    }
}
