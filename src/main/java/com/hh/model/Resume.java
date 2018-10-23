package com.hh.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer r_id;
    private Integer v_id;
    private String r_title;
    private String r_name;
    private String r_sex;
    private String r_location;
    private String r_age;
    private String r_phone;
    private String r_email;
    private String r_school;
    private String r_school_time;
    private String r_major;
    private String r_education;
    private String r_worker;
    private String r_worker_time;
    private String r_worker_experience;
    private String r_job_intention;
    private String r_certificate;
    private String r_hobby;
    private String r_self_assessment;
    private Integer r_state;

    public Resume() {
    }

    public Resume(Integer v_id) {
        this.v_id = v_id;
    }

    public Resume(Integer v_id, Integer r_state) {
        this.v_id = v_id;
        this.r_state = r_state;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_location() {
        return r_location;
    }

    public void setR_location(String r_location) {
        this.r_location = r_location;
    }

    public String getR_age() {
        return r_age;
    }

    public void setR_age(String r_age) {
        this.r_age = r_age;
    }

    public String getR_phone() {
        return r_phone;
    }

    public void setR_phone(String r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_school() {
        return r_school;
    }

    public void setR_school(String r_school) {
        this.r_school = r_school;
    }

    public String getR_school_time() {
        return r_school_time;
    }

    public void setR_school_time(String r_school_time) {
        this.r_school_time = r_school_time;
    }

    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public String getR_education() {
        return r_education;
    }

    public void setR_education(String r_education) {
        this.r_education = r_education;
    }

    public String getR_worker() {
        return r_worker;
    }

    public void setR_worker(String r_worker) {
        this.r_worker = r_worker;
    }

    public String getR_worker_time() {
        return r_worker_time;
    }

    public void setR_worker_time(String r_worker_time) {
        this.r_worker_time = r_worker_time;
    }

    public String getR_worker_experience() {
        return r_worker_experience;
    }

    public void setR_worker_experience(String r_worker_experience) {
        this.r_worker_experience = r_worker_experience;
    }

    public String getR_job_intention() {
        return r_job_intention;
    }

    public void setR_job_intention(String r_job_intention) {
        this.r_job_intention = r_job_intention;
    }

    public String getR_certificate() {
        return r_certificate;
    }

    public void setR_certificate(String r_certificate) {
        this.r_certificate = r_certificate;
    }

    public String getR_hobby() {
        return r_hobby;
    }

    public void setR_hobby(String r_hobby) {
        this.r_hobby = r_hobby;
    }

    public String getR_self_assessment() {
        return r_self_assessment;
    }

    public void setR_self_assessment(String r_self_assessment) {
        this.r_self_assessment = r_self_assessment;
    }

    public Integer getR_state() {
        return r_state;
    }

    public void setR_state(Integer r_state) {
        this.r_state = r_state;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", v_id=" + v_id +
                ", r_title='" + r_title + '\'' +
                ", r_name='" + r_name + '\'' +
                ", r_sex='" + r_sex + '\'' +
                ", r_location='" + r_location + '\'' +
                ", r_age='" + r_age + '\'' +
                ", r_phone='" + r_phone + '\'' +
                ", r_email='" + r_email + '\'' +
                ", r_school='" + r_school + '\'' +
                ", r_school_time='" + r_school_time + '\'' +
                ", r_major='" + r_major + '\'' +
                ", r_education='" + r_education + '\'' +
                ", r_worker='" + r_worker + '\'' +
                ", r_worker_time='" + r_worker_time + '\'' +
                ", r_worker_experience='" + r_worker_experience + '\'' +
                ", r_job_intention='" + r_job_intention + '\'' +
                ", r_certificate='" + r_certificate + '\'' +
                ", r_hobby='" + r_hobby + '\'' +
                ", r_self_assessment='" + r_self_assessment + '\'' +
                ", r_state=" + r_state +
                '}';
    }
}
