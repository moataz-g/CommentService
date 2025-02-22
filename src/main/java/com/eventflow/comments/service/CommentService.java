package com.eventflow.comments.service;

import com.eventflow.comments.model.Comment;
import com.eventflow.comments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByEvent(Long eventId) {
        return commentRepository.findByEventId(eventId);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.findById(id).map(comment -> {
            comment.setContent(updatedComment.getContent());
            return commentRepository.save(comment);
        }).orElse(null);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    public Comment likeComment(Long id) {
        return commentRepository.findById(id).map(comment -> {
            comment.setLikes(comment.getLikes() + 1);
            return commentRepository.save(comment);
        }).orElse(null);
    }

    public Comment dislikeComment(Long id) {
        return commentRepository.findById(id).map(comment -> {
            comment.setDislikes(comment.getDislikes() + 1);
            return commentRepository.save(comment);
        }).orElse(null);
    }

}
