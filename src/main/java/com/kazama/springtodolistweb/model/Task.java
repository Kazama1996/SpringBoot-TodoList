package com.kazama.springtodolistweb.model;

import java.util.Date;

public class Task {
        String task_Name;
        Date created_Date;
        Date deadLine;

        public String getTask_Name() {
                return task_Name;
        }

        public void setTask_Name(String task_Name) {
                this.task_Name = task_Name;
        }

        public Date getCreated_Date() {
                return created_Date;
        }

        public void setCreated_Date(Date created_Date) {
                this.created_Date = created_Date;
        }

        public Date getDeadLine() {
                return deadLine;
        }

        public void setDeadLine(Date deadLine) {
                this.deadLine = deadLine;
        }
}

