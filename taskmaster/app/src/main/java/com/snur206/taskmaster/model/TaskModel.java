package com.snur206.taskmaster.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

// TODO: Step 2-1: Make a data class
// TODO Step: 4-3: Change model into an Entity
@Entity
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    private String title;
    // TODO Step: 4-2: edit model class to reflect the enum
    private TaskStateEnum state;
    private java.util.Date date;
    private String description;

    public TaskModel(String title, TaskStateEnum state, Date date, String description) {
        this.title = title;
        this.state = state;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStateEnum getState() {
        return state;
    }

    public void setState(TaskStateEnum state) {
        this.state = state;
    }

    // TODO Step: 4-1 create the enum
    public enum TaskStateEnum {
        NEW("New"),
        ASSIGNED("Assigned"),
        IN_PROGRESS("In Progress"),
        COMPLETE("Complete");

        private final String taskBody;

        TaskStateEnum(String taskBody) {
            this.taskBody = taskBody;
        }

        public static TaskStateEnum fromString(String possibleTaskBody) {
            for(TaskStateEnum type : TaskStateEnum.values()) {
                if(type.taskBody.equals(possibleTaskBody)) {
                    return type;
                }
            }
            return null;
        }


        @Override
        public String toString() {
            return "TaskStateEnum{" +
                    "taskBody='" + taskBody + '\'' +
                    '}';
        }
    }
}
