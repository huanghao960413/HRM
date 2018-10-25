package com.hh.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer d_id;
    private String d_name;
    private String d_time;

    public Department() {
    }

    public Department(Integer d_id) {
        this.d_id = d_id;
    }

    public Department(String d_name, String d_time) {
        this.d_name = d_name;
        this.d_time = d_time;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_time() {
        return d_time;
    }

    public void setD_time(String d_time) {
        this.d_time = d_time;
    }
}
