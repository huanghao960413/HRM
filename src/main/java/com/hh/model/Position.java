package com.hh.model;

import java.io.Serializable;

public class Position implements Serializable {
    private Integer p_id;
    private String p_name;
    private Integer d_id;

    public Position() {
    }

    public Position(Integer p_id) {
        this.p_id = p_id;
    }

    public Position(String p_name, Integer d_id) {
        this.p_name = p_name;
        this.d_id = d_id;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }
}
