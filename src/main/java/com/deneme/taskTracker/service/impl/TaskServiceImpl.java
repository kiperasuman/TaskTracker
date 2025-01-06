package com.deneme.taskTracker.service.impl;

import com.deneme.taskTracker.dto.DtoTask;
import com.deneme.taskTracker.dto.DtoTaskIU;
import com.deneme.taskTracker.entity.Task;
import com.deneme.taskTracker.enums.TaskStatus;
import com.deneme.taskTracker.repository.ITaskRepository;
import com.deneme.taskTracker.service.ITaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public DtoTask saveTask(DtoTaskIU input) {
        DtoTask dto = new DtoTask();
        Task task = new Task();
        task.setCreatedTime(new Date());
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setStatus(input.getStatus());
        Task savedDb = taskRepository.save(task);
        BeanUtils.copyProperties(savedDb, dto);
        return dto;
    }

    @Override
    public List<DtoTask> getAllTask() {
        List<DtoTask> list = new ArrayList<>();
        List<Task> allTasks = taskRepository.findAll();
        for (Task task : allTasks) {
            DtoTask dtoTask = new DtoTask();
            dtoTask.setId(task.getId());
            dtoTask.setStatus(task.getStatus());
            dtoTask.setDescription(task.getDescription());
            dtoTask.setTitle(task.getTitle());
            list.add(dtoTask);
        }
        return list;
    }

    @Override
    public boolean deleteTask(Long id) {
        Optional<Task> fromDb = taskRepository.findById(id);
        if (fromDb.isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public DtoTask updateTask(Long id, DtoTaskIU input) {
        Optional<Task> fromDb = taskRepository.findById(id);
        DtoTask dtoTask = new DtoTask();
        try {
            if (fromDb.isPresent()) {
                Task task = fromDb.get();
                task.setTitle(input.getTitle());
                task.setStatus(input.getStatus());
                task.setDescription(input.getDescription());
                task.setUpdatedTime(new Date());
                Task savedDb = taskRepository.save(task);
                BeanUtils.copyProperties(savedDb, dtoTask);
            }
            return dtoTask;
        }catch (Exception e){
            System.out.println("İşlem başarısız: "+e.getMessage());
        }
        return null;
    }
}
