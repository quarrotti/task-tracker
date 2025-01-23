package com.example.task_tracker.api.services;

import com.example.task_tracker.api.dto.TaskDto;
import com.example.task_tracker.api.repositories.TaskRepository;
import com.example.task_tracker.store.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    public TaskEntity findById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskEntity> findAllByProject(Long id){
        return taskRepository.findAllByProjectOrderByCreatedAt(projectService.findById(id));
    }
    public void createTask(TaskDto taskDto, Long project_id){
        TaskEntity task = new TaskEntity();

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setProject(projectService.findById(project_id));

        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
