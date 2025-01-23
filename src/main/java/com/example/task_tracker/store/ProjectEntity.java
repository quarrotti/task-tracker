package com.example.task_tracker.store;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "project")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    List<TaskEntity> tasks;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    CustomerEntity customer;

    @PrePersist
    public void init(){
        this.createdAt = LocalDateTime.now();
    }
}
