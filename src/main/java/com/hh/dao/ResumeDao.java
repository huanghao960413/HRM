package com.hh.dao;

import com.hh.model.Resume;

public interface ResumeDao {

    Integer addResume(Resume resume);

    Integer delResume(Resume resume);

    Integer updateResume(Resume resume);

    Resume queryResume(Resume resume);

}
