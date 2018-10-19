package com.hh.model;

import java.io.Serializable;

public class Visitor implements Serializable {
    private Integer v_id;
    private String v_name;
    private String v_pass;

    public Visitor() {
    }

    public Visitor(String v_name) {
        this.v_name = v_name;
    }

    public Visitor(String v_name, String v_pass) {
        this.v_name = v_name;
        this.v_pass = v_pass;
    }

    public Visitor(Integer v_id, String v_name, String v_pass) {
        this.v_id = v_id;
        this.v_name = v_name;
        this.v_pass = v_pass;
    }

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_pass() {
        return v_pass;
    }

    public void setV_pass(String v_pass) {
        this.v_pass = v_pass;
    }
}
