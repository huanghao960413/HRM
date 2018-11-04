package com.hh.controller.admin;

import com.hh.model.Wage;
import com.hh.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminWageController {
    @Autowired
    private WageService wageService;

    @RequestMapping("/adminWageShow")
    public String adminWageShow() throws Exception {
        return "adminWageShow";
    }

    @RequestMapping("/adminWageShowBySid")
    public String adminWageShowBySid(HttpServletRequest request) throws Exception {
        Integer s_id = Integer.parseInt(request.getParameter("s_id"));
        String w_date = request.getParameter("w_date");
        Wage wage = wageService.queryWage(new Wage(s_id, w_date));
        request.setAttribute("wage", wage);
        return "adminWageShowBySid";
    }

    @RequestMapping("/adminWageAdd")
    public String adminWageAdd() {
        return "adminWageAdd";
    }

    @RequestMapping("/adminWageShowAdd")
    public String adminWageShowAdd(HttpServletRequest request) throws Exception {
        Integer s_id = Integer.valueOf(request.getParameter("s_id"));
        String w_date = request.getParameter("w_date");
        Wage wage = wageService.settlementWage(new Wage(s_id, w_date));
        request.setAttribute("s_id", s_id);
        request.setAttribute("wage", wage);
        return "adminWageShowAdd";
    }

    @RequestMapping("/adminWageAddDo")
    public String adminWageAddDo(Wage wage, HttpServletRequest request) throws Exception {
        Integer result = wageService.addWage(wage);
        if (result > 0) {
            request.setAttribute("s_id", wage.getS_id());
            request.setAttribute("w_date", wage.getW_date());
            return "adminWageShowBySid";
        }
        return "adminWageShowAdd";
    }


    @RequestMapping("/adminWageUpdate")
    public String adminWageReviewUpdate(HttpServletRequest request) {
        Integer w_id = Integer.valueOf(request.getParameter("w_id"));
        Integer w_state = Integer.valueOf(request.getParameter("w_state"));
        Wage wage = wageService.queryWage(new Wage(w_id));
        wage.setW_state(w_state);
        wageService.updateWage(wage);
        return "redirect:adminRewardPunishShow";
    }


}
