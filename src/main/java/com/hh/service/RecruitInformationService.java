package com.hh.service;

import com.hh.model.RecruitInformation;

import java.util.HashMap;
import java.util.List;

public interface RecruitInformationService {

    Integer addRecruitInformation(RecruitInformation recruitInformation);

    Integer delRecruitInformation(RecruitInformation recruitInformation);

    Integer updateRecruitInformation(RecruitInformation recruitInformation);

    RecruitInformation queryRecruitInformation(RecruitInformation recruitInformation);

    List<RecruitInformation> queryRecruitInformationList(RecruitInformation recruitInformation);

    List<RecruitInformation> queryRecruitInformationLimit(HashMap<String, Object> hashMap);

}
