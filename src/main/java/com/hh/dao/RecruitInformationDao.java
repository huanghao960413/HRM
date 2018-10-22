package com.hh.dao;

import com.hh.model.RecruitInformation;

import java.util.HashMap;
import java.util.List;

public interface RecruitInformationDao {

    RecruitInformation queryRecruitInformation(RecruitInformation recruitInformation);

    List<RecruitInformation> queryRecruitInformationList(RecruitInformation recruitInformation);

    List<RecruitInformation> queryRecruitInformationLimit(HashMap<String, Object> hashMap);

}
