package com.hh.model;

import java.io.Serializable;

public class RecruitInformation implements Serializable {
    private Integer ri_id;
    private String ri_worker;
    private String ri_salary;
    private String ri_education;
    private String ri_experience;
    private String ri_number;
    private String ri_time;

    public RecruitInformation() {
    }

    public Integer getRi_id() {
        return ri_id;
    }

    public void setRi_id(Integer ri_id) {
        this.ri_id = ri_id;
    }

    public String getRi_worker() {
        return ri_worker;
    }

    public void setRi_worker(String ri_worker) {
        this.ri_worker = ri_worker;
    }

    public String getRi_salary() {
        return ri_salary;
    }

    public void setRi_salary(String ri_salary) {
        this.ri_salary = ri_salary;
    }

    public String getRi_education() {
        return ri_education;
    }

    public void setRi_education(String ri_education) {
        this.ri_education = ri_education;
    }

    public String getRi_experience() {
        return ri_experience;
    }

    public void setRi_experience(String ri_experience) {
        this.ri_experience = ri_experience;
    }

    public String getRi_number() {
        return ri_number;
    }

    public void setRi_number(String ri_number) {
        this.ri_number = ri_number;
    }

    public String getRi_time() {
        return ri_time;
    }

    public void setRi_time(String ri_time) {
        this.ri_time = ri_time;
    }

    @Override
    public String toString() {
        return "RecruitInformation{" +
                "ri_id=" + ri_id +
                ", ri_worker='" + ri_worker + '\'' +
                ", ri_salary='" + ri_salary + '\'' +
                ", ri_education='" + ri_education + '\'' +
                ", ri_experience='" + ri_experience + '\'' +
                ", ri_number='" + ri_number + '\'' +
                ", ri_time='" + ri_time + '\'' +
                '}';
    }
}
