package com.example.task_tracker.api.services;

import com.example.task_tracker.api.repositories.CustomerRepository;
import com.example.task_tracker.store.CustomerEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyCustomerDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public Optional<CustomerEntity> findByLogin(String login){
        return customerRepository.findByLogin(login);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomerEntity customer = findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException(String
                        .format("Пользователь с таким login не найдет")));
        return new CustomerEntity(
                customer.getLogin(),
                customer.getPassword());
    }
}
