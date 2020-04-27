package com.example.lesson64.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Document(collection = "tasks")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Task {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String title;
    private boolean status;
}
