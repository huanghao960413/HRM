package com.hh.controller.visitor;

import com.hh.model.RecruitFlow;
import com.hh.model.RecruitInformation;
import com.hh.model.Resume;
import com.hh.model.Visitor;
import com.hh.service.RecruitFlowService;
import com.hh.service.RecruitInformationService;
import com.hh.service.ResumeService;
import com.hh.util.PageUtil;
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
    @Autowired
    private ResumeService resumeService;
    private final int PAGESIZE = 2;

    //根据游客id查看投递信息
    @RequestMapping("/visitorRecruitFlowShow")
    public String visitorRecruitFlowShow(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        RecruitFlow queRecruitFlow = new RecruitFlow();
        queRecruitFlow.setV_id(visitor.getV_id());
        int totalRows = recruitFlowService.queryRecruitFlowList(queRecruitFlow).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
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

    //进入投递页面
    @RequestMapping("/visitorRecruitFlowAdd")
    public String visitorRecruitFlowAdd(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Resume queryResume = new Resume();
        queryResume.setV_id(visitor.getV_id());
        List<Resume> resumeList = resumeService.queryResumeList(queryResume);
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        request.setAttribute("ri_id", ri_id);
        request.setAttribute("resumeList", resumeList);
        return "visitorRecruitFlowAdd";
    }

    //投递简历
    @RequestMapping("/visitorRecruitFlowAddDo")
    public String visitorRecruitFlowAddDo(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer r_id = Integer.parseInt(request.getParameter("r_id"));
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        recruitFlowService.addRecruitFlow(new RecruitFlow(ri_id, visitor.getV_id(), r_id));
        return "redirect:visitorIndex";
    }

    //根据投递id删除投递信息(未确定使用)
    @RequestMapping("/visitorRecruitFlowDel")
    public String visitorRecruitFlowDel(HttpServletRequest request, HttpSession session) throws Exception {
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

    //根据投递id确认面试
    @RequestMapping("/visitorRecruitFlowInterview")
    public String visitorRecruitFlowInterview(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer rf_id = Integer.parseInt(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        recruitFlow.setRf_state(2);
        recruitFlowService.updateRecruitFlow(recruitFlow);
        return "redirect:visitorIndex";
    }

}
