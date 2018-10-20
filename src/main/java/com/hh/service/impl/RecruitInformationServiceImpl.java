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
