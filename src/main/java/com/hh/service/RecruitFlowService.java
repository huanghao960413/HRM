package com.hh.service;

import com.hh.model.RecruitFlow;

import java.util.HashMap;
import java.util.List;

public interface RecruitFlowService {

    Integer addRecruitFlow(RecruitFlow recruitFlow);

    Integer delRecruitFlow(RecruitFlow recruitFlow);

    Integer updateRecruitFlow(RecruitFlow recruitFlow);

    RecruitFlow queryRecruitFlow(RecruitFlow recruitFlow);

    List<RecruitFlow> queryRecruitFlowList(RecruitFlow recruitFlow);

    List<RecruitFlow> queryRecruitFlowLimit(HashMap<String, Object> hashMap);

}
