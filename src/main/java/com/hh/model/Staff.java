package com.hh.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private Integer s_id;
    private String s_name;
    private String s_pass;
    private String s_full_name;
    private String s_sex;
    private String s_age;
    private String s_phone;
    private String s_email;
    private Double s_salary;
    private Integer d_id;
    private Integer p_id;
    private Integer s_state;

    public Staff() {
    }

    public Staff(Integer s_id) {
        this.s_id = s_id;
    }

    public Staff(String s_name, String s_pass, String s_full_name, String s_sex, String s_age, String s_phone, String s_email, Integer d_id, Integer p_id) {
        this.s_name = s_name;
        this.s_pass = s_pass;
        this.s_full_name = s_full_name;
        this.s_sex = s_sex;
        this.s_age = s_age;
        this.s_phone = s_phone;
        this.s_email = s_email;
        this.d_id = d_id;
        this.p_id = p_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_pass() {
        return s_pass;
    }

    public void setS_pass(String s_pass) {
        this.s_pass = s_pass;
    }

    public String getS_full_name() {
        return s_full_name;
    }

    public void setS_full_name(String s_full_name) {
        this.s_full_name = s_full_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_age() {
        return s_age;
    }

    public void setS_age(String s_age) {
        this.s_age = s_age;
    }

    public String getS_phone() {
        return s_phone;
    }

    public void setS_phone(String s_phone) {
        this.s_phone = s_phone;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public Double getS_salary() {
        return s_salary;
    }

    public void setS_salary(Double s_salary) {
        this.s_salary = s_salary;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getS_state() {
        return s_state;
    }

    public void setS_state(Integer s_state) {
        this.s_state = s_state;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_pass='" + s_pass + '\'' +
                ", s_full_name='" + s_full_name + '\'' +
                ", s_sex='" + s_sex + '\'' +
                ", s_age='" + s_age + '\'' +
                ", s_phone='" + s_phone + '\'' +
                ", s_email='" + s_email + '\'' +
                ", s_salary=" + s_salary +
                ", d_id=" + d_id +
                ", p_id=" + p_id +
                ", s_state=" + s_state +
                '}';
    }
}
