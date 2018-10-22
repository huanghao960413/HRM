package com.hh.controller;

import com.hh.model.RecruitFlow;
import com.hh.model.RecruitInformation;
import com.hh.model.Visitor;
import com.hh.service.RecruitFlowService;
import com.hh.service.RecruitInformationService;
import com.hh.util.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private final int PAGESIZE = 2;

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

}
