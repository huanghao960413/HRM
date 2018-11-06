package com.hh.controller.admin;

import com.hh.model.Train;
import com.hh.service.TrainService;
import com.hh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminTrainController {
    @Autowired
    private TrainService trainService;
    private final int PAGESIZE = 2;

    //培训项目管理页面
    @RequestMapping("/adminTrainShow")
    public String adminTrainShow(HttpServletRequest request) {
        int totalRows = trainService.queryTrainList(new Train()).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<Train> trainList = trainService.queryTrainLimit(hashMap);
        request.setAttribute("trainList", trainList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "adminTrainShow";
    }

    //新增培训项目页面
    @RequestMapping("/adminTrainAdd")
    public String adminTrainAdd() throws Exception {
        return "adminTrainAdd";
    }

    //新增培训项目
    @RequestMapping("/adminTrainAddDo")
    public String adminTrainAddDo(Train train, HttpServletRequest request) throws Exception {
        Integer result = trainService.addTrain(train);
        if (result < 1) {
            request.setAttribute("msg","新增失败");
            return "adminTrainAdd";
        }
        return "redirect:adminTrainShow";
    }

    //删除培训项目
    @RequestMapping("/adminTrainDel")
    public String adminTrainDel(HttpServletRequest request) {
        Integer t_id = Integer.valueOf(request.getParameter("t_id"));
        trainService.delTrain(new Train(t_id));
        return "redirect:adminTrainShow";
    }

    //培训项目修改页面
    @RequestMapping("/adminTrainUpdate")
    public String adminTrainUpdate(HttpServletRequest request) throws Exception {
        Integer t_id = Integer.valueOf(request.getParameter("t_id"));
        Train train = trainService.queryTrain(new Train(t_id));
        request.setAttribute("train",train);
        return "adminTrainUpdate";
    }

    //修改培训项目
    @RequestMapping("/adminTrainUpdateDo")
    public String adminTrainUpdateDo(Train train, HttpServletRequest request) throws Exception {
        Integer result = trainService.updateTrain(train);
        if (result < 1) {
            if (result == 0) {
                request.setAttribute("msg","修改失败");
            }
            if (result == -1) {
                request.setAttribute("msg","");
            }
            return "adminTrainUpdate";
        }
        return "redirect:adminTrainShow";
    }

}
