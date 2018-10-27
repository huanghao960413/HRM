package com.hh.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer t_id;
    private String t_name;
    private String t_message;
    private String t_start_time;
    private String t_over_time;
    private String t_address;

    public Train() {
    }

    public Train(Integer t_id) {
        this.t_id = t_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_message() {
        return t_message;
    }

    public void setT_message(String t_message) {
        this.t_message = t_message;
    }

    public String getT_start_time() {
        return t_start_time;
    }

    public void setT_start_time(String t_start_time) {
        this.t_start_time = t_start_time;
    }

    public String getT_over_time() {
        return t_over_time;
    }

    public void setT_over_time(String t_over_time) {
        this.t_over_time = t_over_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

}
