package com.hh.controller.admin;

import com.hh.model.WageReview;
import com.hh.service.WageReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminWageReviewController {
    @Autowired
    private WageReviewService wageReviewService;

    @RequestMapping("/adminWageReviewShow")
    public String adminWageReviewShow(HttpServletRequest request) {
        Integer w_id = Integer.valueOf(request.getParameter("w_id"));
        WageReview wageReview = wageReviewService.queryWageReview(new WageReview(w_id));
        request.setAttribute("wageReview", wageReview);
        return "adminWageReviewShow";
    }

}
