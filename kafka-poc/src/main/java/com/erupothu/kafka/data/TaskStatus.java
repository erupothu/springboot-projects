package com.erupothu.kafka.data;
import java.util.Objects;

public class TaskStatus {
    
    private String taskId;
    private String taskName;
    private float percentageComplete;
    private Status status;
  
    public enum Status {
      SUBMITTED, STARTED, RUNNING, FINISHED, TERMINATED
    }


    public TaskStatus() {
    }

    public TaskStatus(String taskId, String taskName, float percentageComplete, Status status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.percentageComplete = percentageComplete;
        this.status = status;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public float getPercentageComplete() {
        return this.percentageComplete;
    }

    public void setPercentageComplete(float percentageComplete) {
        this.percentageComplete = percentageComplete;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskStatus taskId(String taskId) {
        setTaskId(taskId);
        return this;
    }

    public TaskStatus taskName(String taskName) {
        setTaskName(taskName);
        return this;
    }

    public TaskStatus percentageComplete(float percentageComplete) {
        setPercentageComplete(percentageComplete);
        return this;
    }

    public TaskStatus status(Status status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskStatus)) {
            return false;
        }
        TaskStatus taskStatus = (TaskStatus) o;
        return Objects.equals(taskId, taskStatus.taskId) && Objects.equals(taskName, taskStatus.taskName) && percentageComplete == taskStatus.percentageComplete && Objects.equals(status, taskStatus.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskName, percentageComplete, status);
    }

    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", taskName='" + getTaskName() + "'" +
            ", percentageComplete='" + getPercentageComplete() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
    

}
