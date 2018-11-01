package com.hh.controller.staff;

import com.hh.model.Staff;
import com.hh.model.Train;
import com.hh.model.TrainRecord;
import com.hh.service.TrainRecordService;
import com.hh.service.TrainService;
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
@RequestMapping("/staff")
public class TrainRecordController {
    @Autowired
    private TrainRecordService trainRecordService;
    @Autowired
    private TrainService trainService;
    private final int PAGESIZE = 2;

    @RequestMapping("/trainRecordShow")
    public String trainRecordShow(HttpServletRequest request, HttpSession session) throws Exception {
        Staff staff = (Staff) session.getAttribute("staff");
        if (staff == null) {
            return "redirect:/staff/login";
        }
        TrainRecord queryTrainRecord = new TrainRecord();
        queryTrainRecord.setS_id(staff.getS_id());
        int totalRows = trainRecordService.queryTrainRecordList(queryTrainRecord).size();
        int totalPages = PageUtil.getTotalPages(totalRows, PAGESIZE);
        int currentPage = 1;
        if (request.getParameter("currentPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("s_id", staff.getS_id());
        hashMap.put("currentPage", (currentPage - 1) * PAGESIZE + 1);
        hashMap.put("pageSize", PAGESIZE * currentPage);
        List<TrainRecord> recordList = trainRecordService.queryTrainRecordLimit(hashMap);
        List<Train> trainList = new ArrayList<Train>();
        for (TrainRecord tr : recordList) {
            trainList.add(trainService.queryTrain(new Train(tr.getT_id())));
        }
        request.setAttribute("trainList", trainList);
        request.setAttribute("recordList", recordList);
        request.setAttribute("s_id", staff.getS_id());
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        return "staff/trainRecordShow";
    }

}
