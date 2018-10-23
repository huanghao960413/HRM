package com.hh.service;

import com.hh.model.Resume;

import java.util.List;

public interface ResumeService {

    Integer addResume(Resume resume);

    Integer delResume(Resume resume);

    Integer updateResume(Resume resume);

    Resume queryResume(Resume resume);

    List<Resume> queryResumeList(Resume resume);

}
