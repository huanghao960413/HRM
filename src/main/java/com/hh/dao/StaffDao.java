package com.hh.dao;

import com.hh.model.Staff;

import java.util.HashMap;
import java.util.List;

public interface StaffDao {

    Integer addStaff(Staff department);

    Integer delStaff(Staff department);

    Integer updateStaff(Staff department);

    Staff queryStaff(Staff department);

    List<Staff> queryStaffList(Staff department);

    List<Staff> queryStaffLimit(HashMap<String, Object> hashMap);

}
