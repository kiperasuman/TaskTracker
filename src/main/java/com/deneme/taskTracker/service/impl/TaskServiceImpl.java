package com.deneme.taskTracker.service.impl;

import com.deneme.taskTracker.dto.DtoTask;
import com.deneme.taskTracker.dto.DtoTaskIU;
import com.deneme.taskTracker.entity.Task;
import com.deneme.taskTracker.errorHandler.DataResult;
import com.deneme.taskTracker.exceptions.BaseException;
import com.deneme.taskTracker.exceptions.ErrorMessage;
import com.deneme.taskTracker.exceptions.MessageType;
import com.deneme.taskTracker.repository.ITaskRepository;
import com.deneme.taskTracker.service.ITaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public DataResult<DtoTask> saveTask(DtoTaskIU input) {
        DtoTask dto = new DtoTask();
        Task task = new Task();
        task.setCreatedTime(new Date());
        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setStatus(input.getStatus());
        Task savedDb = taskRepository.save(task);
        BeanUtils.copyProperties(savedDb, dto);
        return new DataResult<>(dto,true);
    }

    @Override
    public DataResult<List<DtoTask>> getAllTask() {
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
        return new DataResult<>(list,true);
    }

    @Override
    public DataResult<?> deleteTask(Long id) {
        Optional<Task> fromDb = taskRepository.findById(id);
        if (fromDb.isPresent()) {
             taskRepository.deleteById(id);
             return new DataResult<>(id,true);

        }
        return new DataResult<>(false,"Task silme işlemi başarısız.");
    }


    @Override
    public DataResult<DtoTask> updateTask(Long id, DtoTaskIU input) {
        Optional<Task> fromDb = taskRepository.findById(id);
        DtoTask dtoTask = new DtoTask();
        if (fromDb.isEmpty()) {
          throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
        }
        Task task = fromDb.get();
        task.setTitle(input.getTitle());
        task.setStatus(input.getStatus());
        task.setDescription(input.getDescription());
        task.setUpdatedTime(new Date());
        Task savedDb = taskRepository.save(task);
        BeanUtils.copyProperties(savedDb, dtoTask);
        return new DataResult<>(dtoTask,true);
    }

    @Override
    public DataResult<List<DtoTask>> sortByTitleAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        List<Task> sortByTitle = taskRepository.findAll(sort);
        List<DtoTask> dtoTasks = new ArrayList<>();
        for (Task task1 : sortByTitle){
            DtoTask dtoTask = new DtoTask();
            dtoTask.setId(task1.getId());
            dtoTask.setTitle(task1.getTitle());
            dtoTask.setDescription(task1.getDescription());
            dtoTask.setStatus(task1.getStatus());
            dtoTasks.add(dtoTask);
        }
        return new DataResult<>(dtoTasks,true);
    }

}
