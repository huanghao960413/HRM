package com.hh.controller;

import com.hh.model.RecruitFlow;
import com.hh.model.Resume;
import com.hh.service.RecruitFlowService;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitFlowService recruitFlowService;

    @RequestMapping("/adminResumeShow")
    public String adminResumeShow(HttpServletRequest request, HttpSession session) throws Exception {
        Integer v_id = Integer.parseInt(request.getParameter("v_id"));
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(new RecruitFlow(v_id));
        if (recruitFlow.getRf_consult() == 0) {
            recruitFlow.setRf_consult(1);
            recruitFlowService.updateRecruitFlow(recruitFlow);
        }
        Resume resume = resumeService.queryResume(new Resume(v_id));
        request.setAttribute("resume", resume);
        return "adminResumeShow";
    }

}
