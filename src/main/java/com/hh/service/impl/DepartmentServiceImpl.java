package com.hh.service.impl;

import com.hh.dao.DepartmentDao;
import com.hh.dao.PositionDao;
import com.hh.dao.StaffDao;
import com.hh.model.Department;
import com.hh.model.Position;
import com.hh.model.Staff;
import com.hh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private StaffDao staffDao;

    public Integer addDepartment(Department department) {
        if (department == null) {
            return 0;
        }
        if (departmentDao.queryDepartment(department) != null) {
            return -1;
        }
        return departmentDao.addDepartment(department);
    }

    public Integer delDepartment(Department department) {
        if (department == null) {
            return 0;
        }
        Staff queryStaff = new Staff();
        queryStaff.setD_id(department.getD_id());
        List<Staff> staffList = staffDao.queryStaffList(queryStaff);
        for (Staff s : staffList) {
            if (s.getS_state() != -1) {
                return -1;
            }
        }
        Position queryPosition = new Position();
        queryPosition.setD_id(department.getD_id());
        List<Position> positionList = positionDao.queryPositionList(queryPosition);
        for (Position p : positionList) {
            positionDao.delPosition(p);
        }
        return departmentDao.delDepartment(department);
    }

    public Integer updateDepartment(Department department) {
        if (department == null) {
            return 0;
        }
        return departmentDao.updateDepartment(department);
    }

    public Department queryDepartment(Department department) {
        if (department == null) {
            return null;
        }
        return departmentDao.queryDepartment(department);
    }

    public List<Department> queryDepartmentList(Department department) {
        if (department == null) {
            return null;
        }
        return departmentDao.queryDepartmentList(department);
    }

    public List<Department> queryDepartmentLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return departmentDao.queryDepartmentLimit(hashMap);
    }

}
