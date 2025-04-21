package com.eventflow.comments.service;

import com.eventflow.comments.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Long id);
    Comment addComment(Comment comment);
    void deleteComment(Long id);
    Comment likeComment(Long id);
    Comment dislikeComment(Long id);

    // ✅ Add updateComment method
    Comment updateComment(Long id, Comment updatedComment);
}
