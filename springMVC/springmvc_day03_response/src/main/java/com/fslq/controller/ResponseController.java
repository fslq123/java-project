package com.fslq.controller;

import com.fslq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 响应
* */
@Controller
@RequestMapping("responses")
public class ResponseController {
    //返回实体类
    @RequestMapping("user")
    public String responseUser(User user){
        return "response";
    }
    @ModelAttribute
    public void setModel(Model model,User user){//修饰
        model.addAttribute( "user",user );
        //System.out.println(model.getAttribute( "user" ));
    }

    //返回Void
    @RequestMapping("void")
    public void responseVoid(HttpServletRequest request,HttpServletResponse response){
        //1.使用 request 转向页面
/*        try{
            request.getRequestDispatcher( "/WEB-INF/pages/success.jsp" ).forward( request,response );
        }catch(ServletException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }*/
        //2.response 页面重定向
      /*  try{
            response.sendRedirect(request.getContextPath()+"/index.jsp" );
        }catch(IOException e){
            e.printStackTrace();
        }*/
        //3.通过 response 指定响应结果
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        try{
            response.getWriter().write("json 串");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //跳转：模型到视图
    @RequestMapping("modelAndView")
    public ModelAndView modelAndView(User user){
        //创建ModelAndView对象
        ModelAndView mav=new ModelAndView();
        //存储:User对象不为null
        mav.addObject( "user",user );
        //跳转
        mav.setViewName( "response" );
        System.out.println(mav.getModelMap());
        return mav;
    }
    //跳转：关键字
    @RequestMapping("forwardOrRedirect")
    public String forwardOrRedirect(){
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:void";
    }
}
