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
@RequestMapping("/visitor")
public class VisitorRecruitFlowController {
    @Autowired
    private RecruitFlowService recruitFlowService;
    @Autowired
    private RecruitInformationService recruitInformationService;
    @Autowired
    private ResumeService resumeService;
    private final int PAGESIZE = 2;

    //根据游客id查看投递信息
    @RequestMapping("/recruitFlowShow")
    public String recruitFlowShow(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
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
        return "visitor/recruitFlowShow";
    }

    //进入投递页面
    @RequestMapping("/recruitFlowAdd")
    public String recruitFlowAdd(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Resume queryResume = new Resume();
        queryResume.setV_id(visitor.getV_id());
        List<Resume> resumeList = resumeService.queryResumeList(queryResume);
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        request.setAttribute("ri_id", ri_id);
        request.setAttribute("resumeList", resumeList);
        return "visitor/recruitFlowAdd";
    }

    //投递简历
    @RequestMapping("/recruitFlowAddDo")
    public String recruitFlowAddDo(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer r_id = Integer.parseInt(request.getParameter("r_id"));
        Integer ri_id = Integer.parseInt(request.getParameter("ri_id"));
        Integer result = recruitFlowService.addRecruitFlow(new RecruitFlow(ri_id, visitor.getV_id(), r_id));
        System.out.println(result);
        return "redirect:/visitor/index";
    }

    //根据投递id删除投递信息(未确定使用)
    @RequestMapping("/recruitFlowDel")
    public String recruitFlowDel(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer rf_id = Integer.parseInt(request.getParameter("rf_id"));
        RecruitFlow recruitFlow = new RecruitFlow();
        recruitFlow.setRf_id(rf_id);
        recruitFlowService.delRecruitFlow(recruitFlow);
        return "redirect:/visitor/index";
    }

    //根据投递id确认面试
    @RequestMapping("/recruitFlowInterview")
    public String recruitFlowInterview(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer rf_id = Integer.parseInt(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        recruitFlow.setRf_state(2);
        recruitFlowService.updateRecruitFlow(recruitFlow);
        return "redirect:/visitor/index";
    }

}
