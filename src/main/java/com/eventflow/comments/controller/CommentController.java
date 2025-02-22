package com.eventflow.comments.controller;

import com.eventflow.comments.model.Comment;
import com.eventflow.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/event/{eventId}")
    public List<Comment> getCommentsByEvent(@PathVariable Long eventId) {
        return commentService.getCommentsByEvent(eventId);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        return commentService.updateComment(id, updatedComment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
    @PutMapping("/{id}/like")
    public Comment likeComment(@PathVariable Long id) {
        return commentService.likeComment(id);
    }

    @PutMapping("/{id}/dislike")
    public Comment dislikeComment(@PathVariable Long id) {
        return commentService.dislikeComment(id);
    }

}
