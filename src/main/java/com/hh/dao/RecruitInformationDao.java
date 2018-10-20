package com.hh.dao;

import com.hh.model.RecruitInformation;

import java.util.HashMap;
import java.util.List;

public interface RecruitInformationDao {

    List<RecruitInformation> queryRecruitInformationList(RecruitInformation recruitInformation);

    List<RecruitInformation> queryRecruitInformationLimit(HashMap<String, Object> hashMap);

}
