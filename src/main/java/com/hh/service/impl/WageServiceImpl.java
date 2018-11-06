package com.hh.service.impl;

import com.hh.dao.*;
import com.hh.model.*;
import com.hh.service.WageService;
import com.hh.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WageServiceImpl implements WageService {
    @Autowired
    private WageDao wageDao;
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private RewardPunishDao rewardPunishDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private WageReviewDao wageReviewDao;

    public Integer addWage(Wage wage) {
        if (wage == null) {
            return 0;
        }
        if (wageDao.queryWage(wage) != null) {
            return -1;
        }
        if (DateUtil.getYearMonth().compareTo(wage.getW_date()) < 1) {
            return -2;
        }
        wage.setW_last_pay(wage.getW_salary() + wage.getW_performance() + wage.getW_overtime() +
                wage.getW_reward_punish() - wage.getW_social_security());
        wage.setW_state(0);
        return wageDao.addWage(wage);
    }

    public Integer updateWage(Wage wage) {
        if (wage == null) {
            return 0;
        }
        WageReview wageReview = wageReviewDao.queryWageReview(new WageReview(wage.getW_id()));
        if (wage.getW_state() == 2) {
            if (wageReview.getWr_state() == 0) {
                rewardPunishDao.addRewardPunish(new RewardPunish(
                        wage.getS_id(), DateUtil.getDate(), "薪资复议", wageReview.getWr_money(), 1));
            } else {
                rewardPunishDao.addRewardPunish(new RewardPunish(
                        wage.getS_id(), DateUtil.getDate(), "薪资复议", wageReview.getWr_money(), 0));
            }
        }
        return wageDao.updateWage(wage);
    }

    public Wage queryWage(Wage wage) {
        if (wage == null) {
            return null;
        }
        return wageDao.queryWage(wage);
    }

    public Wage settlementWage(Wage wage) {
        if (wage == null) {
            return null;
        }
        List<Attendance> attendanceList = attendanceDao.queryAttendanceList(new Attendance(wage.getS_id(), wage.getW_date()));
        int count = 0;
        for (Attendance a : attendanceList) {
            if (a.getA_state() != 4) {
                count++;
            }
        }
        //基本薪资,加班
        Staff staff = staffDao.queryStaff(new Staff(wage.getS_id()));
        if (count >= 22) {
            wage.setW_overtime((count - 22) * (staff.getS_salary() / 22));
            wage.setW_salary(staff.getS_salary());
        } else {
            wage.setW_overtime(0.00);
            wage.setW_salary(staff.getS_salary() / 22 * count);
        }
        //奖惩记录
        List<RewardPunish> rewardPunishList = rewardPunishDao.queryRewardPunishList(new RewardPunish(wage.getS_id(), wage.getW_date()));
        Double rp_money = 0.00;
        for (RewardPunish rp : rewardPunishList) {
            if (rp.getRp_state() == 1) {
                rp_money += rp.getRp_money();
            } else {
                rp_money -= rp.getRp_money();
            }
        }
        wage.setW_reward_punish(rp_money);

        //社保
        wage.setW_social_security(wage.getW_salary() / 10);
        wage.setW_performance(0.00);
        return wage;
    }
}
