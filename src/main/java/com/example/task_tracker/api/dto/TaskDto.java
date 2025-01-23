package com.example.task_tracker.api.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    @NonNull
    String name;
    @NonNull
    String description;
}
