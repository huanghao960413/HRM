package com.hh.service.impl;

import com.hh.dao.RecruitFlowDao;
import com.hh.dao.ResumeDao;
import com.hh.model.RecruitFlow;
import com.hh.model.Resume;
import com.hh.service.RecruitFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecruitFlowServiceImpl implements RecruitFlowService {
    @Autowired
    private RecruitFlowDao recruitFlowDao;
    @Autowired
    private ResumeDao resumeDao;

    public Integer addRecruitFlow(RecruitFlow recruitFlow) {
        if (recruitFlow == null) {
            return 0;
        }
        if (recruitFlowDao.queryRecruitFlow(recruitFlow) != null) {
            return 1;
        }
        Resume resume = resumeDao.queryResume(new Resume(recruitFlow.getR_id()));
        if (resume.getR_state() == 0) {
            resume.setR_state(1);
            if (resumeDao.updateResume(resume) < 1) {
                return 0;
            }
        }
        return recruitFlowDao.addRecruitFlow(recruitFlow);
    }

    public Integer delRecruitFlow(RecruitFlow recruitFlow) {
        if (recruitFlow == null) {
            return 0;
        }
        return recruitFlowDao.delRecruitFlow(recruitFlow);
    }

    public Integer updateRecruitFlow(RecruitFlow recruitFlow) {
        if (recruitFlow == null) {
            return 0;
        }
        if (recruitFlow.getRf_state() == 1) {
            
        }
        return recruitFlowDao.updateRecruitFlow(recruitFlow);
    }

    public RecruitFlow queryRecruitFlow(RecruitFlow recruitFlow) {
        if (recruitFlow == null) {
            return null;
        }
        return recruitFlowDao.queryRecruitFlow(recruitFlow);
    }

    public List<RecruitFlow> queryRecruitFlowList(RecruitFlow recruitFlow) {
        if (recruitFlow == null) {
            return null;
        }
        return recruitFlowDao.queryRecruitFlowList(recruitFlow);
    }

    public List<RecruitFlow> queryRecruitFlowLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return recruitFlowDao.queryRecruitFlowLimit(hashMap);
    }
}
