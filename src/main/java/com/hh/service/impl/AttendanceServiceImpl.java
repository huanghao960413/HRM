package com.hh.service.impl;

import com.hh.dao.AttendanceDao;
import com.hh.model.Attendance;
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

    public Integer addAttendance(Attendance attendance) {
        if (attendance == null) {
            return 0;
        }
        String start_time = attendance.getA_start_time();
        int minute = DateUtil.differentTime("09:00:00", start_time);
        if (minute <= 0) {
            attendance.setA_state(0);
        } else {
            if (minute > 60*3) {
                attendance.setA_state(4);
            } else {
                attendance.setA_state(1);
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
                if (minute > 60*3) {
                    attendance.setA_state(4);
                } else {
                    attendance.setA_state(2);
                }
            }
        } else if(attendance.getA_state() == 1) {
            String over_time = attendance.getA_over_time();
            int over_minute = DateUtil.differentTime(over_time, "18:00:00");
            if (over_minute > 0) {
                String start_time = attendance.getA_start_time();
                int start_minute = DateUtil.differentTime("09:00:00", start_time);
                if (start_minute + over_minute < 60*3) {
                    attendance.setA_state(3);
                } else {
                    attendance.setA_state(4);
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
