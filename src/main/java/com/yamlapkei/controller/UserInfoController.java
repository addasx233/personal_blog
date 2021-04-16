package com.yamlapkei.controller;

import com.mysql.jdbc.StringUtils;
import com.yamlapkei.service.UserInfoService;
import com.yamlapkei.view.Result;
import com.yamlapkei.view.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/index.do")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/login.do")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/login");
        return mv;
    }

    @RequestMapping("/login.json")
    @ResponseBody
    public Result loginsubmit(ModelMap map, HttpServletRequest request){
        //1获取参数
        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        //2.校验参数
        if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)) {
            return Result.error("账户密码不能为空");
        }
        UserInfo userInfo = userInfoService.selectUser(name,password);
        if(userInfo==null){
            return Result.error("账户或密码不正确");
        }
        //3.设置session
        request.getSession().setAttribute("userInfo",userInfo);
        return Result.success().add("key","test");
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "admin/login";
    }
//    @RequestMapping("/login.do")
//    public String login(ModelMap map,
//                        @RequestParam(required = false, value = "login_name") String name,
//                        @RequestParam(required = false, value = "login_password") String password) {
//        if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)) {
//            return "login";
//        }
//        UserInfo userInfo = userInfoService.selectUser(name, password);
//        if (userInfo == null) {
//            return "login";
//        }
//
//        return "home";
//    }
}


