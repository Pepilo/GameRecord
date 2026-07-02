package com.pdg.backed.service;

import java.util.List;
import java.util.UUID;

import com.pdg.backed.domain.comment.CreateCommentRequest;
import com.pdg.backed.domain.comment.UpdateCommentRequest;
import com.pdg.backed.domain.comment.entity.Comment;

public interface CommentService {

    Comment createComment(CreateCommentRequest request);

    List<Comment> getComments();

    Comment updateComment(UUID commentId, UpdateCommentRequest request);

    void deleteComment(UUID commentId);
}
