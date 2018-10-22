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
public class VisitorRecruitFlowController {
    @Autowired
    private RecruitFlowService recruitFlowService;
    @Autowired
    private RecruitInformationService recruitInformationService;
    private final int PAGESIZE = 2;

    @RequestMapping("/visitorRecruitFlowShow")
    public String visitorRecruitFlowShow(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int totalRows = recruitFlowService.queryRecruitFlowList(new RecruitFlow(visitor.getV_id())).size();
        int totalPages = PageDao.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        hashMap.put("v_id", visitor.getV_id());
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
        return "visitorRecruitFlowShow";
    }

    @RequestMapping("/visitorRecruitFlowAdd")
    public String visitorRecruitFlowAdd(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        recruitFlowService.addRecruitFlow(new RecruitFlow(ri_id,visitor.getV_id()));
        return "redirect:visitorIndex";
    }

    @RequestMapping("/visitorRecruitFlowDel")
    public String visitorRecruitFlowDel(HttpServletRequest request,HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer rf_id = Integer.parseInt(request.getParameter("rf_id"));
        RecruitFlow recruitFlow = new RecruitFlow();
        recruitFlow.setRf_id(rf_id);
        recruitFlowService.delRecruitFlow(recruitFlow);
        return "redirect:visitorIndex";
    }
}
