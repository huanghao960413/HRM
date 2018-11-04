package com.hh.model;

public class RewardPunish {
    private Integer rp_id;
    private Integer s_id;
    private String rp_date;
    private String rp_message;
    private Double rp_money;
    private Integer rp_state;

    public RewardPunish() {
    }

    public RewardPunish(Integer rp_id) {
        this.rp_id = rp_id;
    }

    public RewardPunish(Integer s_id, String rp_date) {
        this.s_id = s_id;
        this.rp_date = rp_date;
    }

    public RewardPunish(Integer s_id, String rp_date, String rp_message, Double rp_money, Integer rp_state) {
        this.s_id = s_id;
        this.rp_date = rp_date;
        this.rp_message = rp_message;
        this.rp_money = rp_money;
        this.rp_state = rp_state;
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

    public Double getRp_money() {
        return rp_money;
    }

    public void setRp_money(Double rp_money) {
        this.rp_money = rp_money;
    }

    public Integer getRp_state() {
        return rp_state;
    }

    public void setRp_state(Integer rp_state) {
        this.rp_state = rp_state;
    }
}
