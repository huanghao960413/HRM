package com.hh.model;

import java.io.Serializable;

public class TrainRecord implements Serializable {
    private Integer tr_id;
    private Integer t_id;
    private Integer s_id;
    private Integer tr_score;
    private Integer tr_state;

    public TrainRecord() {
    }

    public TrainRecord(Integer tr_id) {
        this.tr_id = tr_id;
    }

    public TrainRecord(Integer t_id, Integer s_id) {
        this.t_id = t_id;
        this.s_id = s_id;
    }

    public Integer getTr_id() {
        return tr_id;
    }

    public void setTr_id(Integer tr_id) {
        this.tr_id = tr_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getTr_score() {
        return tr_score;
    }

    public void setTr_score(Integer tr_score) {
        this.tr_score = tr_score;
    }

    public Integer getTr_state() {
        return tr_state;
    }

    public void setTr_state(Integer tr_state) {
        this.tr_state = tr_state;
    }
}
