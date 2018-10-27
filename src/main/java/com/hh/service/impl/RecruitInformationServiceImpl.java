package com.hh.service.impl;

import com.hh.dao.RecruitFlowDao;
import com.hh.dao.RecruitInformationDao;
import com.hh.model.RecruitFlow;
import com.hh.model.RecruitInformation;
import com.hh.service.RecruitInformationService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecruitInformationServiceImpl implements RecruitInformationService {
    @Autowired
    private RecruitInformationDao recruitInformationDao;
    @Autowired
    private RecruitFlowDao recruitFlowDao;

    public Integer addRecruitInformation(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return 0;
        }
        return recruitInformationDao.addRecruitInformation(recruitInformation);
    }

    public Integer delRecruitInformation(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return 0;
        }
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRi_id(recruitInformation.getRi_id());
        List<RecruitFlow> recruitFlowList = recruitFlowDao.queryRecruitFlowList(queryRecruitFlow);
        if (recruitFlowList != null) {
            for (RecruitFlow rf : recruitFlowList) {
                recruitFlowDao.delRecruitFlow(rf);
            }
        }
        return recruitInformationDao.delRecruitInformation(recruitInformation);
    }

    public Integer updateRecruitInformation(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return 0;
        }
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setRi_id(recruitInformation.getRi_id());
        List<RecruitFlow> recruitFlowList = recruitFlowDao.queryRecruitFlowList(queryRecruitFlow);
        if (recruitFlowList != null) {
            return 1;
        }
        return recruitInformationDao.updateRecruitInformation(recruitInformation);
    }

    public RecruitInformation queryRecruitInformation(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return null;
        }
        return recruitInformationDao.queryRecruitInformation(recruitInformation);
    }

    public List<RecruitInformation> queryRecruitInformationList(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return null;
        }
        return recruitInformationDao.queryRecruitInformationList(recruitInformation);
    }

    public List<RecruitInformation> queryRecruitInformationLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return recruitInformationDao.queryRecruitInformationLimit(hashMap);
    }

}
