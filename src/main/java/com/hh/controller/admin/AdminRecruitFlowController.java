package com.hh.controller.admin;

import com.hh.model.*;
import com.hh.service.RecruitFlowService;
import com.hh.service.RecruitInformationService;
import com.hh.service.ResumeService;
import com.hh.service.StaffService;
import com.hh.util.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminRecruitFlowController {
    @Autowired
    private RecruitFlowService recruitFlowService;
    @Autowired
    private RecruitInformationService recruitInformationService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private StaffService staffService;
    private final int PAGESIZE = 2;

    //根据招聘id查找投递信息
    @RequestMapping("/adminRecruitFlowShow")
    public String adminRecruitFlowShow(HttpServletRequest request) throws Exception {
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        RecruitFlow recruitFlow = new RecruitFlow();
        recruitFlow.setRi_id(ri_id);
        int totalRows = recruitFlowService.queryRecruitFlowList(recruitFlow).size();
        int totalPages = PageDao.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("ri_id", ri_id);
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<RecruitFlow> flowList = recruitFlowService.queryRecruitFlowLimit(hashMap);
        List<RecruitInformation> informationList = new ArrayList<RecruitInformation>();
        for (RecruitFlow flow : flowList) {
            informationList.add(recruitInformationService.queryRecruitInformation(new RecruitInformation(flow.getRi_id())));
        }
        request.setAttribute("flowList", flowList);
        request.setAttribute("informationList", informationList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminRecruitFlowShow";
    }

    //根据投递id淘汰投递信息
    @RequestMapping("/adminRecruitFlowEliminate")
    public String adminRecruitFlowEliminate(HttpServletRequest request) throws Exception {
        Integer rf_id = Integer.valueOf(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        recruitFlow.setRf_state(-1);
        recruitFlowService.updateRecruitFlow(recruitFlow);
        return "redirect:adminIndex";
    }

    //进入面试邀请页面
    @RequestMapping("/adminRecruitFlowInterview")
    public String adminRecruitFlowInterview(HttpServletRequest request) throws Exception {
        request.setAttribute("rf_id", request.getParameter("rf_id"));
        return "adminRecruitFlowInterview";
    }

    //根据投递id邀请面试
    @RequestMapping("/adminRecruitFlowInterviewDo")
    public String adminRecruitFlowInterviewDo(HttpServletRequest request) throws Exception {
        Integer rf_id = Integer.valueOf(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        if (recruitFlow == null) {
            request.setAttribute("msg", "没有此投递");
            return "adminRecruitFlowInterview";
        }
        Integer s_id = Integer.valueOf(request.getParameter("s_id"));
        String rf_time = request.getParameter("rf_time");
        recruitFlow.setS_id(s_id);
        recruitFlow.setRf_time(rf_time);
        recruitFlow.setRf_state(1);
        if (recruitFlowService.updateRecruitFlow(recruitFlow) < 1) {
            request.setAttribute("msg", "操作失败");
            return "adminRecruitFlowInterview";
        }
        return "redirect:adminIndex";
    }

    //进入录取页面
    @RequestMapping("/adminRecruitFlowEmploy")
    public String adminRecruitFlowEmploy(HttpServletRequest request) throws Exception {
        Integer rf_id = Integer.valueOf(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        if (recruitFlow == null) {
            request.setAttribute("msg", "没有此投递");
            return "adminRecruitFlowInterview";
        }

        RecruitInformation information = recruitInformationService.queryRecruitInformation(new RecruitInformation(recruitFlow.getRi_id()));
        Resume queryResume = new Resume();
        queryResume.setR_id(recruitFlow.getR_id());
        Resume resume = resumeService.queryResume(queryResume);
        request.setAttribute("resume", resume);
        request.setAttribute("information",information);
        request.setAttribute("rf_id", rf_id);
        return "adminRecruitFlowEmploy";
    }

    //根据投递id录取员工
    @RequestMapping("/adminRecruitFlowEmployDo")
    public String adminRecruitFlowEmployDo(Staff staff, HttpServletRequest request) throws Exception {
        if (staffService.addStaff(staff) < 1) {
            request.setAttribute("msg", "操作失败");
            return "adminRecruitFlowEmploy";
        }
        Integer rf_id = Integer.valueOf(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        recruitFlow.setRf_state(3);
        recruitFlowService.updateRecruitFlow(recruitFlow);
        return "redirect:adminIndex";
    }

}
