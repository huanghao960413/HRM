package com.hh.service.impl;

import com.hh.dao.DepartmentDao;
import com.hh.model.Department;
import com.hh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Integer addDepartment(Department department) {
        if (department == null) {
            return 0;
        }
        return departmentDao.addDepartment(department);
    }

    public Integer delDepartment(Department department) {
        if (department == null) {
            return 0;
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
