package com.hh.service;

import com.hh.model.Staff;

import java.util.HashMap;
import java.util.List;

public interface StaffService {

    Integer addStaff(Staff staff,Integer rf_id);

    Integer delStaff(Staff staff);

    Integer updateStaff(Staff staff);

    Staff queryStaff(Staff staff);

    List<Staff> queryStaffList(Staff staff);

    List<Staff> queryStaffLimit(HashMap<String, Object> hashMap);

}
