package com.deneme.taskTracker.repository;

import com.deneme.taskTracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task,Long> {
}
