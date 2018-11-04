package com.hh.controller.admin;

import com.hh.model.RewardPunish;
import com.hh.service.RewardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminRewardPunishController {
    @Autowired
    private RewardPunishService rewardPunishService;

    //奖惩查询页面
    @RequestMapping("/adminRewardPunishShow")
    public String adminRewardPunishShow() throws Exception {
        return "adminRewardPunishShow";
    }

    @RequestMapping("/adminRewardPunishShowBySid")
    public String adminRewardPunishShowBySid(HttpServletRequest request) throws Exception {
        Integer s_id = Integer.parseInt(request.getParameter("s_id"));
        String rp_date = request.getParameter("rp_date");
        List<RewardPunish> rewardPunishList = rewardPunishService.queryRewardPunishList(new RewardPunish(s_id, rp_date));
        request.setAttribute("rewardPunishList", rewardPunishList);
        return "adminRewardPunishShowBySid";
    }

    //新增奖惩页面
    @RequestMapping("/adminRewardPunishAdd")
    public String adminRewardPunishAdd() throws Exception {
        return "adminRewardPunishAdd";
    }

    //新增奖惩
    @RequestMapping("/adminRewardPunishAddDo")
    public String adminRewardPunishAddDo(RewardPunish rewardPunish, HttpServletRequest request) throws Exception {
        rewardPunishService.addRewardPunish(rewardPunish);
        return "redirect:adminRewardPunishShow";
    }

    //删除奖惩
    @RequestMapping("/adminRewardPunishDel")
    public String adminRewardPunishDel(HttpServletRequest request) throws Exception {
        Integer rp_id = Integer.valueOf(request.getParameter("rp_id"));
        rewardPunishService.delRewardPunish(new RewardPunish(rp_id));
        return "redirect:adminRewardPunishShow";
    }

}
