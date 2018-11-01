package com.hh.model;

import java.io.Serializable;

public class Attendance implements Serializable {
    private Integer a_id;
    private Integer s_id;
    private String a_date;
    private String a_start_time;
    private String a_over_time;
    private Integer a_state;

    public Attendance() {
    }

    public Attendance(Integer a_id) {
        this.a_id = a_id;
    }

    public Attendance(Integer s_id, String a_date) {
        this.s_id = s_id;
        this.a_date = a_date;
    }

    public Attendance(Integer s_id, String a_date, String a_start_time) {
        this.s_id = s_id;
        this.a_date = a_date;
        this.a_start_time = a_start_time;
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public String getA_start_time() {
        return a_start_time;
    }

    public void setA_start_time(String a_start_time) {
        this.a_start_time = a_start_time;
    }

    public String getA_over_time() {
        return a_over_time;
    }

    public void setA_over_time(String a_over_time) {
        this.a_over_time = a_over_time;
    }

    public Integer getA_state() {
        return a_state;
    }

    public void setA_state(Integer a_state) {
        this.a_state = a_state;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "a_id=" + a_id +
                ", s_id=" + s_id +
                ", a_date='" + a_date + '\'' +
                ", a_start_time='" + a_start_time + '\'' +
                ", a_over_time='" + a_over_time + '\'' +
                ", a_state=" + a_state +
                '}';
    }
}
