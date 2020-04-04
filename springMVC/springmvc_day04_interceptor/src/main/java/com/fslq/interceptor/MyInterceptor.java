package com.fslq.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*自定义拦截器*/
public class MyInterceptor implements HandlerInterceptor {
    /**
     *重写接口默认方法
     *  控制器方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
        System.out.println( "前：自定义拦截器方法执行" );
        return true;//放行
    }

    /**
     * 控制器方法执行之后，success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception*/
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception {
        System.out.println( "后：自定义拦截器方法执行" );
    }

    /**
     * success.jsp执行后
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception {
        System.out.println( "完成：自定义拦截器方法执行" );
    }

}
