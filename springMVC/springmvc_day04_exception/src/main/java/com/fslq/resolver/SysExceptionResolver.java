package com.fslq.resolver;

import com.fslq.exception.SysException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 异常处理器
* */
public class SysExceptionResolver implements HandlerExceptionResolver{
    /**
     * 处理异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) {
        //获取异常对象
        SysException e=null;
        if(ex instanceof SysException){//向下转换
            e=(SysException)ex;
        }else{
            e=new SysException( "系统正在维护" );
        }
        //创建ModelAndView对象
        ModelAndView modelAndView=new ModelAndView( );
        modelAndView.addObject( "message",e.getMessage() );
        modelAndView.setViewName( "exception" );
        return modelAndView;
    }
}
