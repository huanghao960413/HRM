package com.hh.controller.staff;

import com.hh.model.Attendance;
import com.hh.model.Staff;
import com.hh.service.AttendanceService;
import com.hh.util.DateUtil;
import com.hh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    private final int PAGESIZE = 5;

    //员工首页
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpSession session) throws Exception {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        Attendance queryAttendance = new Attendance();
        String yearMonth = DateUtil.getYearMonth();
        queryAttendance.setS_id(staff.getS_id());
        queryAttendance.setA_date(yearMonth);
        int totalRows = attendanceService.queryAttendanceList(queryAttendance).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("s_id", staff.getS_id());
        hashMap.put("a_date",yearMonth);
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Attendance> attendanceList = attendanceService.queryAttendanceLimit(hashMap);
        request.setAttribute("attendanceList", attendanceList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "staff/index";
    }

    //打卡
    @RequestMapping("/attendanceAdd")
    public String attendanceAdd(HttpSession session) throws Exception {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        String date = DateUtil.getDate();
        Attendance attendance = attendanceService.queryAttendance(new Attendance(staff.getS_id(),date));
        System.out.println(attendance);
        Integer result = -1;
        if (attendance == null) {
            String start_time = DateUtil.getTime();
            result = attendanceService.addAttendance(new Attendance(staff.getS_id(),date,start_time));
        } else {
            String over_date = DateUtil.getTime();
            attendance.setA_over_time(over_date);
            result = attendanceService.updateAttendance(attendance);
        }
        return "redirect:/staff/index";
    }

}
