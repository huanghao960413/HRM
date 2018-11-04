package com.hh.service.impl;

import com.hh.dao.RecruitFlowDao;
import com.hh.dao.ResumeDao;
import com.hh.model.RecruitFlow;
import com.hh.model.Resume;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private RecruitFlowDao recruitFlowDao;

    public Integer addResume(Resume resume) {
        if (resume == null) {
            return 0;
        }
        if (resume.getV_id() == null ||
                resume.getR_title().equals("") ||
                resume.getR_name().equals("") ||
                resume.getR_sex().equals("") ||
                resume.getR_location().equals("") ||
                resume.getR_age().equals("") ||
                resume.getR_phone().equals("") ||
                resume.getR_email().equals("")) {
            return 0;
        }
        return resumeDao.addResume(resume);
    }

    public Integer delResume(Resume resume) {
        if (resume == null) {
            return 0;
        }
        if (resume.getR_id() == null) {
            return 0;
        }
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setR_id(resume.getR_id());
        List<RecruitFlow> recruitFlowList = recruitFlowDao.queryRecruitFlowList(queryRecruitFlow);
        if (recruitFlowList.size() != 0) {
            for (RecruitFlow rf : recruitFlowList) {
                if (rf.getRf_state() != -1) {
                    return 1;
                }
            }
        }
        return resumeDao.delResume(resume);
    }

    public Integer updateResume(Resume resume) {
        if (resume == null) {
            return 0;
        }
        if (resume.getR_id() == null ||
                resume.getR_title().equals("") ||
                resume.getR_name().equals("") ||
                resume.getR_sex().equals("") ||
                resume.getR_location().equals("") ||
                resume.getR_age().equals("") ||
                resume.getR_phone().equals("") ||
                resume.getR_email().equals("")) {
            return 0;
        }
        RecruitFlow queryRecruitFlow = new RecruitFlow();
        queryRecruitFlow.setR_id(resume.getR_id());
        List<RecruitFlow> recruitFlowList = recruitFlowDao.queryRecruitFlowList(queryRecruitFlow);
        if (recruitFlowList.size() != 0) {
            for (RecruitFlow rf : recruitFlowList) {
                if (rf.getRf_state() != -1) {
                    return 1;
                }
            }
        }
        return resumeDao.updateResume(resume);
    }

    public Resume queryResume(Resume resume) {
        if (resume == null) {
            return null;
        }
        return resumeDao.queryResume(resume);
    }

    public List<Resume> queryResumeList(Resume resume) {
        if (resume == null) {
            return null;
        }
        return resumeDao.queryResumeList(resume);
    }

}
