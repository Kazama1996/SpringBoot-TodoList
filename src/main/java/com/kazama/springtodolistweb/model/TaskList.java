package com.kazama.springtodolistweb.model;

import java.util.Date;

public class TaskList {

    private Integer taskList_id;
    private Integer user_id;
    private String list_name;
    private Date created_date;
    private Date last_modified_date;

    public Integer getTaskList_id() {
        return taskList_id;
    }

    public void setTaskList_id(Integer taskList_id) {
        this.taskList_id = taskList_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }
}
