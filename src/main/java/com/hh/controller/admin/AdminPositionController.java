package com.hh.controller.admin;

import com.hh.model.Department;
import com.hh.model.Position;
import com.hh.service.DepartmentService;
import com.hh.service.PositionService;
import com.hh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminPositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    private final int PAGESIZE = 2;

    //职位管理页面
    @RequestMapping("/adminPositionShow")
    public String adminPositionShow(HttpServletRequest request) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int totalRows = positionService.queryPositionList(new Position()).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Position> positionList = positionService.queryPositionLimit(hashMap);
        List<Department> departmentList = new ArrayList<Department>();
        for (Position p : positionList) {
            departmentList.add(departmentService.queryDepartment(new Department(p.getD_id())));
        }
        request.setAttribute("positionList", positionList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminPositionShow";
    }

    //新增职位页面
    @RequestMapping("/adminPositionAdd")
    public String adminPositionAdd() throws Exception {
        return "adminPositionAdd";
    }

    //新增职位
    @RequestMapping("/adminPositionAddDo")
    public String adminPositionAddDo(Position position, HttpServletRequest request) throws Exception {
        Integer result = positionService.addPosition(position);
        if (result < 1) {
            if (result == 0) {
                request.setAttribute("msg", "新增失败");
            }
            if (result == -1) {
                request.setAttribute("msg","已有此职位");
            }
            return "adminPositionAdd";
        }
        return "redirect:adminPositionShow";
    }

    //删除职位
    @RequestMapping("/adminPositionDel")
    public String adminPositionDel(HttpServletRequest request) throws Exception {
        Integer p_id = Integer.valueOf(request.getParameter("p_id"));
        positionService.delPosition(new Position(p_id));
        return "redirect:adminPositionShow";
    }

    //修改职位页面
    @RequestMapping("/adminPositionUpdate")
    public String adminPositionUpdate(HttpServletRequest request) throws Exception {
        Integer p_id = Integer.valueOf(request.getParameter("p_id"));
        Position position = positionService.queryPosition(new Position(p_id));
        request.setAttribute("position", position);
        return "adminPositionUpdate";
    }

    //修改职位
    @RequestMapping("/adminPositionUpdateDo")
    public String adminPositionUpdateDo(Position position, HttpServletRequest request) throws Exception {
        Integer result = positionService.updatePosition(position);
        if (result < 1) {
            request.setAttribute("msg", "修改失败");
            return "adminPositionUpdate";
        }
        return "redirect:adminPositionShow";
    }

}
