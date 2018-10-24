package com.hh.controller.visitor;

import com.hh.model.RecruitInformation;
import com.hh.model.Visitor;
import com.hh.service.RecruitInformationService;
import com.hh.util.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class VisitorRecruitInformationController {
    @Autowired
    private RecruitInformationService recruitInformationService;
    private final int PAGESIZE = 2;

    //游客主页(显示招聘信息)
    @RequestMapping("/visitorIndex")
    public String visitorIndex(HttpServletRequest request, HttpSession session) {
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {
            return "redirect:visitorLogin";
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int totalRows = recruitInformationService.queryRecruitInformationList(new RecruitInformation()).size();
        int totalPages = PageDao.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<RecruitInformation> informationList = recruitInformationService.queryRecruitInformationLimit(hashMap);
        request.setAttribute("informationList", informationList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "visitorIndex";
    }

}
