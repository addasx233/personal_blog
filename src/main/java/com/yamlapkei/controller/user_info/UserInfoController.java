package com.yamlapkei.controller.user_info;

import com.mysql.jdbc.StringUtils;
import com.yamlapkei.exception.GlobalException;
import com.yamlapkei.service.user_info.UserInfoService;
import com.yamlapkei.view.Result;
import com.yamlapkei.view.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserInfoController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    //测试异常处理器，修改拦截器放行
    @RequestMapping("/test.do")
    public String test() throws Exception {
        logger.debug("执行测试页面");
//        throw new GlobalException("test");
        throw new Exception();
    }
    @RequestMapping("/index.do")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/login.do")
    public ModelAndView login() {
        logger.debug("进入登陆页面");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/login");
        return mv;
    }

    @RequestMapping("/login.json")
    @ResponseBody
    public Result loginsubmit(ModelMap map, HttpServletRequest request) throws GlobalException {
        //1获取参数
        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        //2.校验参数
        if (StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)) {
            throw new GlobalException("账户密码不能为空");
        }
        UserInfo userInfo = userInfoService.selectUser(name,password);
        if(userInfo==null){
            throw new GlobalException("账户或密码不正确");
        }
        logger.debug("用户"+name+"登陆成功");
        //3.设置session
        request.getSession().setAttribute("userInfo",userInfo);
        return Result.success();
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        logger.debug(userInfo.getName()+"退出登录");
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


