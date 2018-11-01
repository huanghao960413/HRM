package com.hh.dao;

import com.hh.model.Attendance;

import java.util.HashMap;
import java.util.List;

public interface AttendanceDao {

    Integer addAttendance(Attendance attendance);

    Integer updateAttendance(Attendance attendance);

    Integer delAttendance(Attendance attendance);

    Attendance queryAttendance(Attendance attendance);

    List<Attendance> queryAttendanceList(Attendance attendance);

    List<Attendance> queryAttendanceLimit(HashMap<String, Object> hashMap);

}
