package com.hh.model;

import java.io.Serializable;

public class WageReview implements Serializable {
    private Integer wr_id;
    private Integer w_id;
    private String wr_message;
    private Double wr_money;
    private Integer wr_state;

    public WageReview() {
    }

    public WageReview(Integer w_id) {
        this.w_id = w_id;
    }

    public Integer getWr_id() {
        return wr_id;
    }

    public void setWr_id(Integer wr_id) {
        this.wr_id = wr_id;
    }

    public Integer getW_id() {
        return w_id;
    }

    public void setW_id(Integer w_id) {
        this.w_id = w_id;
    }

    public String getWr_message() {
        return wr_message;
    }

    public void setWr_message(String wr_message) {
        this.wr_message = wr_message;
    }

    public Double getWr_money() {
        return wr_money;
    }

    public void setWr_money(Double wr_money) {
        this.wr_money = wr_money;
    }

    public Integer getWr_state() {
        return wr_state;
    }

    public void setWr_state(Integer wr_state) {
        this.wr_state = wr_state;
    }
}
