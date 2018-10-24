package com.hh.dao;

import com.hh.model.Department;

import java.util.HashMap;
import java.util.List;

public interface DepartmentDao {

    Integer addDepartment(Department department);

    Integer delDepartment(Department department);

    Integer updateDepartment(Department department);

    Department queryDepartment(Department department);

    List<Department> queryDepartmentList(Department department);

    List<Department> queryDepartmentLimit(HashMap<String, Object> hashMap);

}
