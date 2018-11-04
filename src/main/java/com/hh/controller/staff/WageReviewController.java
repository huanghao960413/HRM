package com.hh.controller.staff;

import com.hh.model.WageReview;
import com.hh.service.WageReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/staff")
public class WageReviewController {
    @Autowired
    private WageReviewService wageReviewService;

    @RequestMapping("/wageReviewShow")
    public String wageReviewShow(HttpServletRequest request) {
        Integer w_id = Integer.valueOf(request.getParameter("w_id"));
        WageReview wageReview = wageReviewService.queryWageReview(new WageReview(w_id));
        request.setAttribute("wageReview", wageReview);
        return "staff/wageReviewShow";
    }

    @RequestMapping("/wageReviewAdd")
    public String wageReviewAdd(HttpServletRequest request) {
        Integer w_id = Integer.valueOf(request.getParameter("w_id"));
        request.setAttribute("w_id", w_id);
        return "staff/wageReviewAdd";
    }

    @RequestMapping("/wageReviewAddDo")
    public String wageReviewAddDo(WageReview wageReview, HttpServletRequest request) {
        wageReviewService.addWageReview(wageReview);
        return "staff/wageReviewShow";
    }

}
