package com.example.task_tracker.api.repositories;

import com.example.task_tracker.store.ProjectEntity;
import com.example.task_tracker.store.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByProjectOrderByCreatedAt(ProjectEntity project);
}
