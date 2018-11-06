package com.hh.service.impl;

import com.hh.dao.AttendanceDao;
import com.hh.dao.RewardPunishDao;
import com.hh.model.Attendance;
import com.hh.model.RewardPunish;
import com.hh.service.AttendanceService;
import com.hh.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private RewardPunishDao rewardPunishDao;

    public Integer addAttendance(Attendance attendance) {
        if (attendance == null) {
            return 0;
        }
        String start_time = attendance.getA_start_time();
        int minute = DateUtil.differentTime("09:00:00", start_time);
        if (minute <= 0) {
            attendance.setA_state(0);
        } else {
            if (minute > 60 * 3) {
                attendance.setA_state(4);
            } else {
                attendance.setA_state(1);
                rewardPunishDao.addRewardPunish(new RewardPunish(attendance.getS_id(), attendance.getA_date(), "迟到", 50.00, 0));
            }
        }
        return attendanceDao.addAttendance(attendance);
    }

    public Integer updateAttendance(Attendance attendance) {
        if (attendance == null) {
            return 0;
        }
        if (attendance.getA_state() == 0) {
            String over_time = attendance.getA_over_time();
            int minute = DateUtil.differentTime(over_time, "18:00:00");
            if (minute > 0) {
                if (minute > 60 * 3) {
                    attendance.setA_state(4);
                    rewardPunishDao.delRewardPunish(rewardPunishDao.queryRewardPunish(new RewardPunish(attendance.getS_id(), attendance.getA_date())));
                } else {
                    attendance.setA_state(2);
                    rewardPunishDao.addRewardPunish(new RewardPunish(attendance.getS_id(), attendance.getA_date(), "早退", 50.00, 0));
                }
            }
        } else if (attendance.getA_state() == 1) {
            String over_time = attendance.getA_over_time();
            int over_minute = DateUtil.differentTime(over_time, "18:00:00");
            if (over_minute > 0) {
                String start_time = attendance.getA_start_time();
                int start_minute = DateUtil.differentTime("09:00:00", start_time);
                if (start_minute + over_minute < 60 * 3) {
                    attendance.setA_state(3);
                    RewardPunish rewardPunish = rewardPunishDao.queryRewardPunish(new RewardPunish(attendance.getS_id(), attendance.getA_date()));
                    rewardPunish.setRp_message("迟到及早退");
                    rewardPunish.setRp_money(100.00);
                    rewardPunishDao.updateRewardPunish(rewardPunish);
                } else {
                    attendance.setA_state(4);
                    System.out.println(attendance);
                    RewardPunish rewardPunish = rewardPunishDao.queryRewardPunish(new RewardPunish(attendance.getS_id(), attendance.getA_date()));
                    System.out.println(rewardPunish);
                    rewardPunishDao.delRewardPunish(rewardPunish);
                }
            }
        }
        return attendanceDao.updateAttendance(attendance);
    }

    public Integer delAttendance(Attendance attendance) {
        if (attendance == null) {
            return 0;
        }
        return attendanceDao.delAttendance(attendance);
    }

    public Attendance queryAttendance(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        return attendanceDao.queryAttendance(attendance);
    }

    public List<Attendance> queryAttendanceList(Attendance attendance) {
        if (attendance == null) {
            return null;
        }
        return attendanceDao.queryAttendanceList(attendance);
    }

    public List<Attendance> queryAttendanceLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return attendanceDao.queryAttendanceLimit(hashMap);
    }
}
