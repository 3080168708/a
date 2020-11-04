package com.abc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class sysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 当前抛出的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        sysException se=null;
        if (e instanceof sysException){
        se=(sysException)e;
        }else{
            new sysException("其他异常");
        }
        //创建ModelAndView
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        if (se==null){return mav;}
        mav.addObject("error",se.getMac());
        return mav;
    }
}
