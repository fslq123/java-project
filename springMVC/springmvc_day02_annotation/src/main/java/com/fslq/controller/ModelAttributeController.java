package com.fslq.controller;

import com.fslq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/*
*该注解是 SpringMVC4.3 版本以后新加入的。
* 它可以用于修饰方法和参数。
* 出现在方法上，表示当前方法会在控制器的方法执行之前，先执行。
* 它可以修饰没有返回值的方法，也可以修饰有具体返回值的方法。
* 出现在参数上，获取指定的数据给参数赋值。
 * */
@Controller
@RequestMapping("model")
public class ModelAttributeController {
    /*
    *基于 POJO 属性:用于在其他方法中获得参数
    * */
    @RequestMapping("pojo")
    public String pojoModelAttribute(User user)
    {
        if(user.getUname().isEmpty())
            return "error";
        System.out.println( user );
        return "success";
    }
    @ModelAttribute
    public void showPojoModel(User user) {
        System.out.println("执行了基于POJO属性方法"+user.getUname());
    }
    /*
    *基于 Map:用于在其它方法中使用参数
    *  */
    @RequestMapping("map")
    public String mapModelAttribute(User user)
    {
        if(user.getUname().isEmpty())
            return "error";
        System.out.println( user );
        return "success";
    }
    @ModelAttribute
    public void showMapModel(String uname){
        System.out.println("执行了基于Map属性方法"+new User (uname,18,null));
    }
}
