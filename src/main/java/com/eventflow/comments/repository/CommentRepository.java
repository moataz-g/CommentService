package com.eventflow.comments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventflow.comments.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
