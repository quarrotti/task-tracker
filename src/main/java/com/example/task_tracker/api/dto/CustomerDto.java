package com.example.task_tracker.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
    @NonNull
    String login;
    @NonNull
    String password;
}
