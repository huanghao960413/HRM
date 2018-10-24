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
        return null;
    }

    public Integer delDepartment(Department department) {
        return null;
    }

    public Integer updateDepartment(Department department) {
        return null;
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
        return null;
    }

}
