package com.example.task_tracker.api.repositories;

import com.example.task_tracker.store.CustomerEntity;
import com.example.task_tracker.store.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {


    List<ProjectEntity> findAllByCustomer(CustomerEntity customer);
}
