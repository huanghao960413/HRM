package com.hh.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    //进入管理员登录页面
    @RequestMapping("/adminLogin")
    public String adminLogin() throws Exception {
        return "adminLogin";
    }

    //管理员登陆(账号写死为admin)
    @RequestMapping("/adminLoginDo")
    public String adminLoginDo(HttpServletRequest request, HttpSession session) throws Exception {
        String a_name = request.getParameter("a_name");
        String a_pass = request.getParameter("a_pass");
        if (a_name.equals("admin") && a_pass.equals("admin")) {
            session.setAttribute("admin", a_name);
            return "redirect:adminIndex";
        } else {
            request.setAttribute("msg", "用户名或密码错误!");
            return "adminLogin";
        }
    }

}
