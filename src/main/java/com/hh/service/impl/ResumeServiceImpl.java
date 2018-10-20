package com.hh.service.impl;

import com.hh.dao.ResumeDao;
import com.hh.model.Resume;
import com.hh.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    public Integer addResume(Resume resume) {
        if (resume == null) {
            return 0;
        }
        if (resume.getV_id().equals("") ||
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
        if (resume.getV_id() == null) {
            return 0;
        }
        System.out.println(resume.getV_id());
        return resumeDao.delResume(resume);
    }

    public Integer updateResume(Resume resume) {
        if (resume == null) {
            return 0;
        }
        if (resume.getV_id().equals("") ||
                resume.getR_name().equals("") ||
                resume.getR_sex().equals("") ||
                resume.getR_location().equals("") ||
                resume.getR_age().equals("") ||
                resume.getR_phone().equals("") ||
                resume.getR_email().equals("")) {
            return 0;
        }
        return resumeDao.updateResume(resume);
    }

    public Resume queryResume(Resume resume) {
        if (resume == null) {
            return null;
        }
        return resumeDao.queryResume(resume);
    }

}
