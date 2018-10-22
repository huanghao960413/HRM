package com.hh.controller;

import com.hh.model.Resume;
import com.hh.model.Visitor;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VisitorResumeController {
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/visitorResumeShow")
    public String visitorResumeShow(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Resume resume = resumeService.queryResume(new Resume(visitor.getV_id()));
        if (resume == null) {
            return "redirect:visitorResumeAdd";
        } else {
            request.setAttribute("resume", resume);
            return "visitorResumeShow";
        }
    }

    @RequestMapping("/visitorResumeAdd")
    public String visitorResumeAdd() {
        return "visitorResumeAdd";
    }

    @RequestMapping("/visitorResumeAddDo")
    public String visitorResumeAddDo(Resume resume, HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        resume.setV_id(visitor.getV_id());
        resume.setR_state(0);
        Integer result = resumeService.addResume(resume);
        if (result == 0) {
            request.setAttribute("msg", "请正确输入信息");
            return "visitorResumeAdd";
        } else {
            return "redirect:visitorResumeShow";
        }
    }

    @RequestMapping("/visitorResumeDel")
    public String visitorResumeDel(Resume resume, HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer result = resumeService.delResume(new Resume(visitor.getV_id()));
        if (result == 0) {
            request.setAttribute("msg", "删除失败");
            return "visitorResumeShow";
        } else {
            return "redirect:visitorIndex";
        }
    }

    @RequestMapping("/visitorResumeUpdate")
    public String visitorResumeUpdate(HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Resume resume = resumeService.queryResume(new Resume(visitor.getV_id()));
        if (resume == null) {
            return "redirect:visitorResumeShow";
        } else {
            request.setAttribute("resume", resume);
            return "visitorResumeUpdate";
        }
    }

    @RequestMapping("/visitorResumeUpdateDo")
    public String visitorResumeUpdateDo(Resume resume, HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer result = resumeService.updateResume(resume);
        if (result == 0) {
            request.setAttribute("msg", "请正确输入信息");
            return "visitorResumeUpdate";
        } else {
            return "redirect:visitorResumeShow";
        }
    }

}
