package com.kazama.springtodolistweb.dto;

import java.util.Date;

public class TaskListRequest {

    private String taskList_name;
    private Date created_date;
    private Date last_modified_date;

    public String getTaskList_name() {
        return taskList_name;
    }

    public void setTaskList_name(String taskList_name) {
        this.taskList_name = taskList_name;
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
