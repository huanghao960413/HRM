package com.hh.controller;

import com.hh.model.Department;
import com.hh.model.Position;
import com.hh.model.Staff;
import com.hh.model.Visitor;
import com.hh.service.DepartmentService;
import com.hh.service.PositionService;
import com.hh.service.StaffService;
import com.hh.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AjaxController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private StaffService staffService;

    //判断用户名是否存在
    @RequestMapping("/ajaxVisitorByName")
    public void ajaxVisitorByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String v_name = request.getParameter("v_name");
        Visitor visitor = visitorService.queryVisitor(new Visitor(v_name));
        if (visitor == null) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    //查找部门
    @RequestMapping("/ajaxDepartment")
    public @ResponseBody List ajaxDepartment() throws Exception {
        List<Department> departmentList = departmentService.queryDepartmentList(new Department());
        return departmentList;
    }

    //根据部门id查找职位
    @RequestMapping("/ajaxPosition")
    public @ResponseBody List ajaxPosition(HttpServletRequest request) throws Exception {
        Integer d_id = Integer.valueOf(request.getParameter("d_id"));
        Position queryPosition = new Position();
        queryPosition.setD_id(d_id);
        List<Position> positionList = positionService.queryPositionList(queryPosition);
        return positionList;
    }

    //根据职位id查找员工
    @RequestMapping("/ajaxStaff")
    public @ResponseBody List ajaxStaff(HttpServletRequest request) throws Exception {
        Integer p_id = Integer.valueOf(request.getParameter("p_id"));
        Staff queryStaff = new Staff();
        queryStaff.setP_id(p_id);
        queryStaff.setS_state(1);
        List<Staff> staffList = staffService.queryStaffList(queryStaff);
        return staffList;
    }

}
