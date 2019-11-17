package com.tayfurunal.validations.exception;

public class TaskIdExceptionResponse {
    private String taskId;

    TaskIdExceptionResponse(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
