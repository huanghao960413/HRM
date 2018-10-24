package com.hh.controller.admin;

import com.hh.model.RecruitFlow;
import com.hh.model.Resume;
import com.hh.service.RecruitFlowService;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitFlowService recruitFlowService;

    //根据投递id查找简历
    @RequestMapping("/adminResumeShow")
    public String adminResumeShow(HttpServletRequest request) throws Exception {
        Integer rf_id = Integer.parseInt(request.getParameter("rf_id"));
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRf_id(rf_id);
        RecruitFlow recruitFlow = recruitFlowService.queryRecruitFlow(queryRecruitFlow);
        if (recruitFlow.getRf_consult() == 0) {
            recruitFlow.setRf_consult(1);
            recruitFlowService.updateRecruitFlow(recruitFlow);
        }
        Resume queryResume = new Resume();
        queryResume.setR_id(recruitFlow.getR_id());
        Resume resume = resumeService.queryResume(queryResume);
        request.setAttribute("resume", resume);
        return "adminResumeShow";
    }

}
