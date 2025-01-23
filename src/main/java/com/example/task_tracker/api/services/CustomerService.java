package com.example.task_tracker.api.services;

import com.example.task_tracker.api.dto.CustomerDto;
import com.example.task_tracker.api.repositories.CustomerRepository;
import com.example.task_tracker.store.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public CustomerEntity findByLogin(Principal principal){
        return customerRepository.findByLogin(principal.getName()).orElse(null);
    }

    public void registry(CustomerDto customerDto){
        CustomerEntity customer = new CustomerEntity();

        customer.setLogin(customerDto.getLogin());
        customer.setPassword(customerDto.getPassword());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        customerRepository.save(customer);
    }

}
