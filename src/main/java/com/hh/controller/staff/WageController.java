package com.hh.controller.staff;

import com.hh.model.Staff;
import com.hh.model.Wage;
import com.hh.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class WageController {
    @Autowired
    private WageService wageService;

    @RequestMapping("/wageShow")
    public String wageShow() {
        return "staff/wageShow";
    }

    @RequestMapping("/wageShowByDate")
    public String wageShowByDate(HttpServletRequest request, HttpSession session) {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        String w_date = request.getParameter("w_date");
        Wage wage = wageService.queryWage(new Wage(staff.getS_id(), w_date));
        request.setAttribute("wage", wage);
        return "staff/wageShowByDate";
    }

}
