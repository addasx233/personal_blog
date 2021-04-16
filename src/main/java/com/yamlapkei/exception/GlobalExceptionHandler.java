package com.yamlapkei.exception;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //如果是json请求就返回json，跳转页面则跳到错误页面
        //判断是否为预期的错误
        String message = "系统繁忙";
        e.printStackTrace();
        if(e instanceof GlobalException){
            message=((GlobalException)e).getMessage();
        }
        //判断请求类型
        HandlerMethod handlerMethod = (HandlerMethod) o;
        ResponseBody responseBody = handlerMethod.getMethod().getAnnotation(ResponseBody.class);
        //有responseBode即为json请求
        if(responseBody != null){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("code","999999");
            map.put("message",message);
            String json = new Gson().toJson(map);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            try {
                httpServletResponse.getWriter().write(json);
                httpServletResponse.getWriter().flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return new ModelAndView();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        //跳转到WEB-INF/page/error.jsp
        modelAndView.setViewName("error");
        return modelAndView;

    }
}
