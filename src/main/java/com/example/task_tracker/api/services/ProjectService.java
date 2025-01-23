package com.example.task_tracker.api.services;

import com.example.task_tracker.api.dto.ProjectDto;
import com.example.task_tracker.api.repositories.ProjectRepository;
import com.example.task_tracker.store.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final CustomerService customerService;

    public ProjectEntity findById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public List<ProjectEntity> findAllByUser(Principal principal){
        return projectRepository.findAllByCustomer(customerService.findByLogin(principal));
    }

    public void createProject(ProjectDto projectDto, Principal principal){
        ProjectEntity project = new ProjectEntity();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setCustomer(customerService.findByLogin(principal));

        projectRepository.save(project);
    }

    public void deleteProject(Long id){
        if(projectRepository.findById(id) != null) projectRepository.deleteById(id);
    }
}
