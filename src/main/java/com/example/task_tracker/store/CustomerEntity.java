package com.example.task_tracker.store;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "customer")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CustomerEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String login;

    String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    List<ProjectEntity> projects;

    public CustomerEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Если аккаунт не должен истекать
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Если аккаунт не должен быть заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Если учетные данные не должны истекать
    }

    @Override
    public boolean isEnabled() {
        return true; // Если аккаунт должен быть активен
    }
}
