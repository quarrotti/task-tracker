package com.example.task_tracker.api.repositories;

import com.example.task_tracker.store.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByLogin(String login);
}
