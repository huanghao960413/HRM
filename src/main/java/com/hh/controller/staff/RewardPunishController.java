package com.hh.controller.staff;

import com.hh.model.RewardPunish;
import com.hh.model.Staff;
import com.hh.service.RewardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class RewardPunishController {
    @Autowired
    private RewardPunishService rewardPunishService;

    //奖惩查询页面
    @RequestMapping("/rewardPunishShow")
    public String rewardPunishShow() throws Exception {
        return "staff/rewardPunishShow";
    }

    @RequestMapping("/rewardPunishShowByMonth")
    public String rewardPunishShowByMonth(HttpServletRequest request, HttpSession session) throws Exception {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        String rp_date = request.getParameter("rp_date");
        List<RewardPunish> rewardPunishList = rewardPunishService.queryRewardPunishList(new RewardPunish(staff.getS_id(), rp_date));
        request.setAttribute("rewardPunishList", rewardPunishList);
        return "staff/rewardPunishShowByMonth";
    }

}
