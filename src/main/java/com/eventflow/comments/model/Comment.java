package com.eventflow.comments.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long eventId;

    @Column(nullable = false, length = 1000)
    private String content;

    private int likes = 0;
    private int dislikes = 0;

    private LocalDateTime createdAt = LocalDateTime.now();
}
