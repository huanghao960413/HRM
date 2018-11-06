package com.hh.controller.admin;

import com.hh.model.Staff;
import com.hh.model.Train;
import com.hh.model.TrainRecord;
import com.hh.service.StaffService;
import com.hh.service.TrainRecordService;
import com.hh.service.TrainService;
import com.hh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminTrainRecordController {
    @Autowired
    private TrainRecordService trainRecordService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private StaffService staffService;
    private final int PAGESIZE = 2;

    //培训管理页面
    @RequestMapping("/adminTrainRecordShow")
    public String adminTrainRecordShow(HttpServletRequest request) {
        int totalRows = trainService.queryTrainList(new Train()).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Train> trainList = trainService.queryTrainLimit(hashMap);
        request.setAttribute("trainList", trainList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminTrainRecordShow";
    }

    //培训管理页面
    @RequestMapping("/adminTrainRecordShowByTid")
    public String adminTrainRecordShowByTid(HttpServletRequest request) {
        Integer t_id = Integer.valueOf(request.getParameter("t_id"));
        TrainRecord queryTrainRecord = new TrainRecord();
        queryTrainRecord.setT_id(t_id);
        int totalRows = trainRecordService.queryTrainRecordList(queryTrainRecord).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("t_id", t_id);
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<TrainRecord> recordList = trainRecordService.queryTrainRecordLimit(hashMap);
        List<Staff> staffList = new ArrayList<Staff>();
        for (TrainRecord tr : recordList) {
            staffList.add(staffService.queryStaff(new Staff(tr.getS_id())));
        }
        request.setAttribute("staffList", staffList);
        request.setAttribute("recordList", recordList);
        request.setAttribute("t_id", t_id);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminTrainRecordShowByTid";
    }

    //新增员工培训页面
    @RequestMapping("/adminTrainRecordAdd")
    public String adminTrainRecordAdd(HttpServletRequest request) throws Exception {
        request.setAttribute("t_id", request.getParameter("t_id"));
        return "adminTrainRecordAdd";
    }

    //新增员工培训
    @RequestMapping("/adminTrainRecordAddDo")
    public String adminTrainRecordAddDo(HttpServletRequest request) throws Exception {
        Integer t_id = Integer.valueOf(request.getParameter("t_id"));
        List<Staff> staffList = null;
        Integer result = 0;
        if (request.getParameter("s_id").equals("")) {
            Staff queryStaff = new Staff();
            if (request.getParameter("p_id").equals("")) {
                queryStaff.setP_id(Integer.valueOf(request.getParameter("d_id")));
            } else {
                queryStaff.setP_id(Integer.valueOf(request.getParameter("p_id")));
            }
            staffList = staffService.queryStaffList(queryStaff);
            for (Staff s : staffList) {
                result = trainRecordService.addTrainRecord(new TrainRecord(t_id, s.getS_id()));
            }
        } else {
            result = trainRecordService.addTrainRecord(new TrainRecord(t_id, Integer.valueOf(request.getParameter("s_id"))));
        }
        return "redirect:adminTrainRecordShow";
    }

    //删除员工培训
    @RequestMapping("/adminTrainRecordDel")
    public String adminTrainRecordDel(HttpServletRequest request) {
        Integer tr_id = Integer.valueOf(request.getParameter("tr_id"));
        trainRecordService.delTrainRecord(new TrainRecord(tr_id));
        return "redirect:adminTrainRecordShow";
    }

}
