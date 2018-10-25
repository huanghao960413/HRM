package com.hh.controller.admin;

import com.hh.model.RecruitInformation;
import com.hh.service.RecruitInformationService;
import com.hh.util.PageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminRecruitInformationController {
    @Autowired
    private RecruitInformationService recruitInformationService;
    private final int PAGESIZE = 2;

    //管理员首页(显示招聘信息)
    @RequestMapping("/adminIndex")
    public String adminIndex(HttpServletRequest request) {
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
        return "adminIndex";
    }

    //招聘信息页面
    @RequestMapping("/adminRecruitInformationShow")
    public String adminRecruitInformationShow(HttpServletRequest request) throws Exception {
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
        return "adminRecruitInformationShow";
    }

    //招聘信息新增页面
    @RequestMapping("/adminRecruitInformationAdd")
    public String adminRecruitInformationAdd() throws Exception {
        return "adminRecruitInformationAdd";
    }

    //新增招聘信息
    @RequestMapping("/adminRecruitInformationAddDo")
    public String adminRecruitInformationAddDo(RecruitInformation recruitInformation, HttpServletRequest request) throws Exception {
        Integer result = recruitInformationService.addRecruitInformation(recruitInformation);
        if (result < 1) {
            request.setAttribute("msg","新增失败");
            return "adminRecruitInformationAdd";
        }
        return "redirect:adminRecruitInformationShow";
    }

    //根据招聘信息id删除招聘信息
    @RequestMapping("/adminRecruitInformationDel")
    public String adminRecruitInformationDel(HttpServletRequest request) throws Exception {
        Integer ri_id = Integer.valueOf(request.getParameter("ri_id"));
        recruitInformationService.delRecruitInformation(new RecruitInformation(ri_id));
        return "redirect:adminRecruitInformationShow";
    }

    //招聘信息修改页面
    @RequestMapping("/adminRecruitInformationUpdate")
    public String adminRecruitInformationUpdate(HttpServletRequest request) throws Exception {
        Integer ri_id = Integer.valueOf(request.getParameter("ri_id"));
        RecruitInformation information = recruitInformationService.queryRecruitInformation(new RecruitInformation(ri_id));
        request.setAttribute("information",information);
        return "adminRecruitInformationUpdate";
    }

    //修改招聘信息
    @RequestMapping("/adminRecruitInformationUpdateDo")
    public String adminRecruitInformationUpdateDo(RecruitInformation recruitInformation, HttpServletRequest request) throws Exception {
        Integer result = recruitInformationService.updateRecruitInformation(recruitInformation);
        if (result < 1) {
            request.setAttribute("msg","修改失败");
            return "adminRecruitInformationUpdate";
        }
        return "redirect:adminRecruitInformationShow";
    }

}
