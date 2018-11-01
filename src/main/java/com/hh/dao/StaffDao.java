package com.hh.dao;

import com.hh.model.Staff;

import java.util.HashMap;
import java.util.List;

public interface StaffDao {

    Integer addStaff(Staff staff);

    Integer delStaff(Staff staff);

    Integer updateStaff(Staff staff);

    Staff queryStaff(Staff staff);

    List<Staff> queryStaffList(Staff staff);

    List<Staff> queryStaffLimit(HashMap<String, Object> hashMap);

}
