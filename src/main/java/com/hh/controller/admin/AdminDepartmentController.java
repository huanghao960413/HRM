package com.hh.controller.admin;

import com.hh.model.Department;
import com.hh.service.DepartmentService;
import com.hh.util.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminDepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final int PAGESIZE = 2;

    //部门管理页面
    @RequestMapping("/adminDepartmentShow")
    public String adminDepartmentShow(HttpServletRequest request) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int totalRows = departmentService.queryDepartmentList(new Department()).size();
        int totalPages = PageDao.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Department> departmentList = departmentService.queryDepartmentLimit(hashMap);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminDepartmentShow";
    }

    //新增部门页面
    @RequestMapping("/adminDepartmentAdd")
    public String adminDepartmentAdd() throws Exception {
        return "adminDepartmentAdd";
    }

    //新增部门
    @RequestMapping("/adminDepartmentAddDo")
    public String adminDepartmentAddDo(Department department, HttpServletRequest request) throws Exception {
        Integer result = departmentService.addDepartment(department);
        if (result < 1) {
            request.setAttribute("msg", "新增失败");
            return "adminDepartmentAdd";
        }
        return "redirect:adminDepartmentShow";
    }

    //删除部门
    @RequestMapping("/adminDepartmentDel")
    public String adminDepartmentDel(HttpServletRequest request) throws Exception {
        Integer d_id = Integer.valueOf(request.getParameter("d_id"));
        departmentService.delDepartment(new Department(d_id));
        return "redirect:adminDepartmentShow";
    }

    //修改部门页面
    @RequestMapping("/adminDepartmentUpdate")
    public String adminDepartmentUpdate(HttpServletRequest request) throws Exception {
        Integer d_id = Integer.valueOf(request.getParameter("d_id"));
        Department department = departmentService.queryDepartment(new Department(d_id));
        request.setAttribute("department",department);
        return "adminDepartmentUpdate";
    }

    //修改部门
    @RequestMapping("/adminDepartmentUpdateDo")
    public String adminDepartmentUpdateDo(Department department, HttpServletRequest request) throws Exception {
        Integer result = departmentService.updateDepartment(department);
        if (result < 1) {
            request.setAttribute("msg","修改失败");
            return "adminDepartmentUpdate";
        }
        return "redirect:adminDepartmentShow";
    }

}
