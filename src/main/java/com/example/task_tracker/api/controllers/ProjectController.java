package com.example.task_tracker.api.controllers;

import com.example.task_tracker.api.dto.ProjectDto;
import com.example.task_tracker.api.services.ProjectService;
import com.example.task_tracker.api.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;

    @GetMapping("/create-project")
    public String createProject(){
        return "project-pages/create-project";
    }

    @PostMapping("/create-project")
    public String createProject(ProjectDto projectDto, Principal principal){
        projectService.createProject(projectDto,principal);
        return "redirect:/general";
    }

    @PostMapping("/delete-project/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return "redirect:/general";
    }

    @GetMapping("/open-project/{id}")
    public String openProject(Model model, @PathVariable Long id){
        model.addAttribute("project", projectService.findById(id));
        model.addAttribute("tasks", taskService.findAllByProject(id));

        return "project-pages/project";
    }
}
