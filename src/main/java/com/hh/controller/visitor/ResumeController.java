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
@RequestMapping("/visitor")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    //根据游客id查找简历
    @RequestMapping("/resumeShowByVid")
    public String resumeShowByVid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Resume queryResume = new Resume();
        queryResume.setV_id(visitor.getV_id());
        List<Resume> resumeList = resumeService.queryResumeList(queryResume);
        request.setAttribute("resumeList", resumeList);
        return "visitor/resumeShowByVid";
    }

    //根据简历id查找简历
    @RequestMapping("/resumeShowByRid")
    public String resumeShowByRid(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer r_id = Integer.parseInt(request.getParameter("r_id"));
        Resume resume = resumeService.queryResume(new Resume(r_id));
        if (resume == null) {
            return "redirect:/visitor/resumeShowByVid";
        } else {
            request.setAttribute("resume", resume);
            return "visitor/resumeShowByRid";
        }
    }

    //进入简历新增页面
    @RequestMapping("/resumeAdd")
    public String resumeAdd() {
        return "visitor/resumeAdd";
    }

    //新增简历
    @RequestMapping("/resumeAddDo")
    public String resumeAddDo(Resume resume, HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        resume.setV_id(visitor.getV_id());
        resume.setR_state(0);
        Integer result = resumeService.addResume(resume);
        if (result == 0) {
            request.setAttribute("msg", "请正确输入信息");
            return "visitor/resumeAdd";
        } else {
            return "redirect:/visitor/resumeShowByVid";
        }
    }

    //根据简历id删除简历
    @RequestMapping("/resumeDel")
    public String resumeDel(HttpServletRequest request, HttpSession session) throws Exception {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer r_id = Integer.valueOf(request.getParameter("r_id"));
        resumeService.delResume(new Resume(r_id));
        return "redirect:/visitor/resumeShowByVid";
    }

    //进入简历修改页面
    @RequestMapping("/resumeUpdate")
    public String resumeUpdate(HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Resume resume = new Resume();
        resume.setR_id(Integer.valueOf(request.getParameter("r_id")));
        resume = resumeService.queryResume(resume);
        if (resume.getR_title() == null) {
            return "redirect:/visitor/resumeShowByVid";
        } else {
            request.setAttribute("resume", resume);
            return "visitor/resumeUpdate";
        }
    }

    //根据简历id修改简历
    @RequestMapping("/resumeUpdateDo")
    public String visitorResumeUpdateDo(Resume resume, HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:/visitor/login";
        }
        Integer result = resumeService.updateResume(resume);
        if (result == 0) {
            request.setAttribute("msg", "请正确输入信息");
            return "visitor/resumeUpdate";
        } else {
            return "redirect:/visitor/resumeShowByVid";
        }
    }

}
