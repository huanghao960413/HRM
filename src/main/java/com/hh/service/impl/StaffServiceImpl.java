package com.hh.service.impl;

import com.hh.dao.StaffDao;
import com.hh.model.Staff;
import com.hh.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public Integer addStaff(Staff staff) {
        if (staff == null) {
            return 0;
        }
        return staffDao.addStaff(staff);
    }

    public Integer delStaff(Staff staff) {
        if (staff == null) {
            return 0;
        }
        return staffDao.delStaff(staff);
    }

    public Integer updateStaff(Staff staff) {
        if (staff == null) {
            return 0;
        }
        return staffDao.updateStaff(staff);
    }

    public Staff queryStaff(Staff staff) {
        if (staff == null) {
            return null;
        }
        return staffDao.queryStaff(staff);
    }

    public List<Staff> queryStaffList(Staff staff) {
        if (staff == null) {
            return null;
        }
        return staffDao.queryStaffList(staff);
    }

    public List<Staff> queryStaffLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return staffDao.queryStaffLimit(hashMap);
    }

}
