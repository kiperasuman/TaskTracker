package com.deneme.taskTracker.controller;

import com.deneme.taskTracker.dto.DtoTask;
import com.deneme.taskTracker.dto.DtoTaskIU;

import java.util.List;

public interface ITaskController {
    DtoTask saveTask(DtoTaskIU input);
    List<DtoTask> getAllTask();
    boolean deleteTask(Long id);
    DtoTask updateTask(Long id,DtoTaskIU input);
}
