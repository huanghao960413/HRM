package com.hh.service.impl;

import com.hh.dao.RecruitInformationDao;
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
        return recruitInformationDao.delRecruitInformation(recruitInformation);
    }

    public Integer updateRecruitInformation(RecruitInformation recruitInformation) {
        if (recruitInformation == null) {
            return 0;
        }
        System.out.println(recruitInformation);
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
