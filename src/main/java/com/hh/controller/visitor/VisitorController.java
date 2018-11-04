package com.hh.controller.visitor;

import com.hh.model.Visitor;
import com.hh.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    //进入登录界面
    @RequestMapping("/login")
    public String login() throws Exception {
        return "visitor/login";
    }

    //登录
    @RequestMapping("/loginDo")
    public String loginDo(HttpServletRequest request, HttpSession session) throws Exception {
        String v_name = request.getParameter("v_name");
        String v_pass = request.getParameter("v_pass");
        Visitor visitor = visitorService.queryVisitor(new Visitor(v_name, v_pass));
        if (visitor == null) {
            request.setAttribute("msg", "用户名或密码错误!");
            return "visitor/login";
        } else {
            session.setAttribute("visitor", visitor);
            return "redirect:/visitor/index";
        }
    }

    //进入注册界面
    @RequestMapping("/register")
    public String register() throws Exception {
        return "visitor/register";
    }

    //注册
    @RequestMapping("/registerDo")
    public String registerDo(HttpServletRequest request) throws Exception {
        String v_name = request.getParameter("v_name");
        String v_pass = request.getParameter("v_pass");
        Integer result = visitorService.addVisitor(new Visitor(v_name,v_pass));
        if (result < 1) {
            request.setAttribute("msg","注册失败");
            return "visitor/register";
        } else {
            return "visitor/login";
        }
    }

}
