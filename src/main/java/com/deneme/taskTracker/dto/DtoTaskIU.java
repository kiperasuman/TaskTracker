package com.deneme.taskTracker.dto;

import com.deneme.taskTracker.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class DtoTaskIU {

    @NotNull(message = "Title değeri boş geçilemez")
    private String title;
    @NotNull(message = "Description değeri boş geçilemez")
    private String description;
    @NotNull(message = "Status değeri boş geçilemez")
    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
