package com.toprate.demo.entity;

public class BaseEntity {

    private String time_create;

    private String time_update;

    private Integer state;


    public void setTime_create(String time_create) {
        this.time_create = time_create;
    }

    public void setTime_update(String time_update) {
        this.time_update = time_update;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
