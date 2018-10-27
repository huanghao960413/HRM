package com.hh.model;

import java.io.Serializable;

public class RecruitFlow implements Serializable {
    private Integer rf_id;
    private Integer ri_id;
    private Integer v_id;
    private Integer r_id;
    private Integer rf_consult;
    private String rf_time;;
    private Integer s_id;
    private Integer rf_state;

    public RecruitFlow() {
    }

    public RecruitFlow(Integer rf_id) {
        this.rf_id = rf_id;
    }

    public RecruitFlow(Integer ri_id, Integer v_id, Integer r_id) {
        this.ri_id = ri_id;
        this.v_id = v_id;
        this.r_id = r_id;
    }

    public Integer getRf_id() {
        return rf_id;
    }

    public void setRf_id(Integer rf_id) {
        this.rf_id = rf_id;
    }

    public Integer getRi_id() {
        return ri_id;
    }

    public void setRi_id(Integer ri_id) {
        this.ri_id = ri_id;
    }

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getRf_consult() {
        return rf_consult;
    }

    public void setRf_consult(Integer rf_consult) {
        this.rf_consult = rf_consult;
    }

    public String getRf_time() {
        return rf_time;
    }

    public void setRf_time(String rf_time) {
        this.rf_time = rf_time;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getRf_state() {
        return rf_state;
    }

    public void setRf_state(Integer rf_state) {
        this.rf_state = rf_state;
    }
}
