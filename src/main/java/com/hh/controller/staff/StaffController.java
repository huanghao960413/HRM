package com.hh.controller.staff;

import com.hh.model.Staff;
import com.hh.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    //进入登录界面
    @RequestMapping("/login")
    public String login() throws Exception {
        return "staff/login";
    }

    //登录
    @RequestMapping("/loginDo")
    public String loginDo(HttpServletRequest request, HttpSession session) throws Exception {
        String s_name = request.getParameter("s_name");
        String s_pass = request.getParameter("s_pass");
        Staff staff = staffService.queryStaff(new Staff(s_name, s_pass));
        if (staff == null) {
            request.setAttribute("msg", "用户名或密码错误!");
            return "staff/login";
        } else {
            session.setAttribute("staff", staff);
            return "redirect:/staff/index";
        }
    }

    @RequestMapping("/staffShow")
    public String staffShow(HttpSession session) throws Exception {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        return "staff/staffShow";
    }

}
