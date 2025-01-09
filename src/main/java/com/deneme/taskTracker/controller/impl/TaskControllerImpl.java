package com.deneme.taskTracker.controller.impl;

import com.deneme.taskTracker.controller.ITaskController;
import com.deneme.taskTracker.dto.DtoTask;
import com.deneme.taskTracker.dto.DtoTaskIU;
import com.deneme.taskTracker.errorHandler.DataResult;
import com.deneme.taskTracker.service.ITaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/task")
public class TaskControllerImpl implements ITaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("/save")
    @Override
    public DataResult<DtoTask> saveTask(@Valid @RequestBody DtoTaskIU input) {
        return taskService.saveTask(input);
    }

    @GetMapping("/get")
    @Override
    public DataResult<List<DtoTask>> getAllTask() {
        return taskService.getAllTask();
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public DataResult<?> deleteTask(@PathVariable(name = "id") Long id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DataResult<DtoTask> updateTask(@PathVariable(name = "id") Long id, @RequestBody DtoTaskIU input) {
        return taskService.updateTask(id,input);
    }

    @GetMapping("/get/sorted-task")
    @Override
    public DataResult<List<DtoTask>> sortByTitleAsc() {
        return taskService.sortByTitleAsc();
    }
}
