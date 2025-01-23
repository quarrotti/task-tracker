package com.example.task_tracker.store;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Table(name = "task")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    ProjectEntity project;

    @PrePersist
    public void init(){
        this.createdAt = LocalDateTime.now();
    }
}
