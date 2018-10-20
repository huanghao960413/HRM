package com.hh.controller;

import com.hh.model.Visitor;
import com.hh.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/visitorLogin")
    public String visitorLogin() throws Exception {
        return "visitorLogin";
    }

    @RequestMapping("/visitorLoginDo")
    public String visitorLoginDo(HttpServletRequest request, HttpSession session) throws Exception {
        String v_name = request.getParameter("v_name");
        String v_pass = request.getParameter("v_pass");
        Visitor visitor = visitorService.queryVisitor(new Visitor(v_name, v_pass));
        if (visitor == null) {
            request.setAttribute("msg", "用户名或密码错误!");
            return "visitorLogin";
        } else {
            session.setAttribute("visitor", visitor);
            return "redirect:visitorIndex";
        }
    }

    @RequestMapping("/visitorRegister")
    public String visitorRegister() throws Exception {
        return "visitorRegister";
    }

    @RequestMapping("/visitorRegisterDo")
    public String visitorRegisterDo(HttpServletRequest request) throws Exception {
        String v_name = request.getParameter("v_name");
        String v_pass = request.getParameter("v_pass");
        Integer result = visitorService.addVisitor(new Visitor(v_name,v_pass));
        if (result == 0) {
            request.setAttribute("msg","注册失败");
            return "visitorRegister";
        } else {
            return "redirect:../../index";
        }
    }

    @RequestMapping("/queryVisitorByName")
    public void queryVisitorByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String v_name = request.getParameter("v_name");
        Visitor visitor = visitorService.queryVisitor(new Visitor(v_name));
        if (visitor == null) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/visitorIndex")
    public String visitorIndex() throws Exception {

        return "visitorIndex";
    }

}
