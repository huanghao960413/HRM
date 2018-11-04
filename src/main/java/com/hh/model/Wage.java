package com.hh.model;

import java.io.Serializable;

public class Wage implements Serializable {
    private Integer w_id;
    private Integer s_id;
    private String w_date;
    private Double w_salary;
    private Double w_performance;
    private Double w_overtime;
    private Double w_reward_punish;
    private Double w_social_security;
    private Double w_last_pay;
    private Integer w_state;

    public Wage() {
    }

    public Wage(Integer w_id) {
        this.w_id = w_id;
    }

    public Wage(Integer s_id, String w_date) {
        this.s_id = s_id;
        this.w_date = w_date;
    }

    public Integer getW_id() {
        return w_id;
    }

    public void setW_id(Integer w_id) {
        this.w_id = w_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getW_date() {
        return w_date;
    }

    public void setW_date(String w_date) {
        this.w_date = w_date;
    }

    public Double getW_salary() {
        return w_salary;
    }

    public void setW_salary(Double w_salary) {
        this.w_salary = w_salary;
    }

    public Double getW_performance() {
        return w_performance;
    }

    public void setW_performance(Double w_performance) {
        this.w_performance = w_performance;
    }

    public Double getW_overtime() {
        return w_overtime;
    }

    public void setW_overtime(Double w_overtime) {
        this.w_overtime = w_overtime;
    }

    public Double getW_reward_punish() {
        return w_reward_punish;
    }

    public void setW_reward_punish(Double w_reward_punish) {
        this.w_reward_punish = w_reward_punish;
    }

    public Double getW_social_security() {
        return w_social_security;
    }

    public void setW_social_security(Double w_social_security) {
        this.w_social_security = w_social_security;
    }

    public Double getW_last_pay() {
        return w_last_pay;
    }

    public void setW_last_pay(Double w_last_pay) {
        this.w_last_pay = w_last_pay;
    }

    public Integer getW_state() {
        return w_state;
    }

    public void setW_state(Integer w_state) {
        this.w_state = w_state;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "w_id=" + w_id +
                ", s_id=" + s_id +
                ", w_date='" + w_date + '\'' +
                ", w_salary=" + w_salary +
                ", w_performance=" + w_performance +
                ", w_overtime=" + w_overtime +
                ", w_reward_punish=" + w_reward_punish +
                ", w_social_security=" + w_social_security +
                ", w_last_pay=" + w_last_pay +
                ", w_state=" + w_state +
                '}';
    }
}
