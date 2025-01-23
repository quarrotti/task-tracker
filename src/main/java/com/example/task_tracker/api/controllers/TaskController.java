package com.example.task_tracker.api.controllers;

import com.example.task_tracker.api.dto.TaskDto;
import com.example.task_tracker.api.services.ProjectService;
import com.example.task_tracker.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final ProjectService projectService;
    private final TaskService taskService;

    @GetMapping("/open-project/{id}/create-task")
    public String createTask(@PathVariable Long id, Model model){
        model.addAttribute("project", projectService.findById(id));
        return "task-pages/create-task";
    }

    @PostMapping("/open-project/{id}/create-task")
    public String createTaskP(TaskDto taskDto, @PathVariable Long id){
        taskService.createTask(taskDto, id);
        return "redirect:/open-project/"+id;
    }

    @PostMapping("/open-project/{project_id}/delete-task/{id}")
    public String deleteTask(@PathVariable Long id, @PathVariable Long project_id){
        taskService.deleteTask(id);

        return "redirect:/open-project/"+project_id;
    }

    @GetMapping("/open-project/{project_id}/open-task/{task_id}")
    public String openTask(Model model, @PathVariable Long task_id, @PathVariable Long project_id){
        model.addAttribute("task", taskService.findById(task_id));
        model.addAttribute("project", projectService.findById(project_id));
        return "task-pages/task";
    }
}
