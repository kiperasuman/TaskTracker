package com.deneme.taskTracker.controller;

import com.deneme.taskTracker.dto.DtoTask;
import com.deneme.taskTracker.dto.DtoTaskIU;
import com.deneme.taskTracker.errorHandler.DataResult;

import java.util.List;

public interface ITaskController {
    DataResult<DtoTask> saveTask(DtoTaskIU input);
    DataResult<List<DtoTask>> getAllTask();
    DataResult<?> deleteTask(Long id);
    DataResult<DtoTask> updateTask(Long id,DtoTaskIU input);
}
