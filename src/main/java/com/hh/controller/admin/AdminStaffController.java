package com.hh.controller.admin;

import com.hh.model.Department;
import com.hh.model.Position;
import com.hh.model.Staff;
import com.hh.service.DepartmentService;
import com.hh.service.PositionService;
import com.hh.service.StaffService;
import com.hh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminStaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PositionService positionService;
    private final int PAGESIZE = 2;

    //员工管理页面
    @RequestMapping("/adminStaffShow")
    public String adminStaffShow(HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int totalRows = staffService.queryStaffList(new Staff()).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Staff> staffList = staffService.queryStaffLimit(hashMap);
        List<Position> positionList = new ArrayList<Position>();
        List<Department> departmentList = new ArrayList<Department>();
        for (Staff s : staffList) {
            positionList.add(positionService.queryPosition(new Position(s.getP_id())));
            departmentList.add(departmentService.queryDepartment(new Department(s.getD_id())));
        }
        request.setAttribute("staffList", staffList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminStaffShow";
    }

    //员工管理页面
    @RequestMapping("/adminStaffUpdate")
    public String adminStaffUpdate(HttpServletRequest request) {
        Integer s_id = Integer.valueOf(request.getParameter("s_id"));
        Staff staff = staffService.queryStaff(new Staff(s_id));
        request.setAttribute("staff", staff);
        return "adminStaffUpdate";
    }

    //员工修改
    @RequestMapping("/adminStaffUpdateDo")
    public String adminStaffUpdateDo(Staff staff, HttpServletRequest request) {
        Integer result = staffService.updateStaff(staff);
        if (result < 1) {
            request.setAttribute("msg", "修改失败");
            return "adminStaffUpdate";
        }
        return "redirect:adminStaffShow";
    }

}
