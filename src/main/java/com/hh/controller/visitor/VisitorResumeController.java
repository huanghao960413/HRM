package com.hh.controller.visitor;

import com.hh.model.Resume;
import com.hh.model.Visitor;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VisitorResumeController {
    @Autowired
    private ResumeService resumeService;

    //根据游客id查找简历
    @RequestMapping("/visitorResumeShowByVid")
    public String visitorResumeShowByVid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        List<Resume> resumeList = resumeService.queryResumeList(new Resume(visitor.getV_id()));
        request.setAttribute("resumeList", resumeList);
        return "visitorResumeShowByVid";
    }

    //根据简历id查找简历
    @RequestMapping("/visitorResumeShowByRid")
    public String visitorResumeShowByRid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Integer r_id = Integer.parseInt(request.getParameter("r_id"));
        Resume queryResume = new Resume();
        queryResume.setR_id(r_id);
        Resume resume = resumeService.queryResume(queryResume);
        if (resume == null) {
            return "redirect:visitorResumeShowByVid";
        } else {
            request.setAttribute("resume", resume);
            return "visitorResumeShowByRid";
        }
    }

    //进入简历新增页面
    @RequestMapping("/visitorResumeAdd")
    public String visitorResumeAdd() {
        return "visitorResumeAdd";
    }

    //新增简历
    @RequestMapping("/visitorResumeAddDo")
    public String visitorResumeAddDo(Resume resume, HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        resume.setV_id(visitor.getV_id());
        resume.setR_state(0);
        System.out.println(resume);
        Integer result = resumeService.addResume(resume);
        if (result == 0) {
            request.setAttribute("msg", "请正确输入信息");
            return "visitorResumeAdd";
        } else {
            return "redirect:visitorResumeShowByVid";
        }
    }

    //根据简历id删除简历
    @RequestMapping("/visitorResumeDel")
    public String visitorResumeDel(Resume resume, HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        resumeService.delResume(resume);
        return "redirect:visitorResumeShowByVid";
    }

    //进入简历修改页面
    @RequestMapping("/visitorResumeUpdate")
    public String visitorResumeUpdate(HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        Resume resume = new Resume();
        resume.setR_id(Integer.valueOf(request.getParameter("r_id")));
        resume = resumeService.queryResume(resume);
        if (resume.getR_title() == null) {
            return "redirect:visitorResumeShowByVid";
        } else {
            request.setAttribute("resume", resume);
            return "visitorResumeUpdate";
        }
    }

    //根据简历id修改简历
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
            return "redirect:visitorResumeShowByVid";
        }
    }

}
