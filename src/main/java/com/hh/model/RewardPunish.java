package com.hh.model;

public class RewardPunish {
    private Integer rp_id;
    private Integer s_id;
    private String rp_date;
    private String rp_message;
    private String rp_money;
    private String rp_state;

    public RewardPunish() {
    }

    public RewardPunish(Integer rp_id) {
        this.rp_id = rp_id;
    }

    public Integer getRp_id() {
        return rp_id;
    }

    public void setRp_id(Integer rp_id) {
        this.rp_id = rp_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getRp_date() {
        return rp_date;
    }

    public void setRp_date(String rp_date) {
        this.rp_date = rp_date;
    }

    public String getRp_message() {
        return rp_message;
    }

    public void setRp_message(String rp_message) {
        this.rp_message = rp_message;
    }

    public String getRp_money() {
        return rp_money;
    }

    public void setRp_money(String rp_money) {
        this.rp_money = rp_money;
    }

    public String getRp_state() {
        return rp_state;
    }

    public void setRp_state(String rp_state) {
        this.rp_state = rp_state;
    }
}
