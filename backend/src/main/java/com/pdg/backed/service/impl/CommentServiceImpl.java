package com.pdg.backed.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdg.backed.domain.CreateCommentRequest;
import com.pdg.backed.domain.UpdateCommentRequest;
import com.pdg.backed.domain.entity.Comment;
import com.pdg.backed.exception.NotFoundException;
import com.pdg.backed.repository.CommentRepository;
import com.pdg.backed.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(CreateCommentRequest request) {
        Comment comment = new Comment(
            request.content()
        );

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll(Sort.by(Sort.Direction.ASC, "commentId"));
    }

    @Override
    public Comment updateComment(UUID commentId, UpdateCommentRequest request) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NotFoundException(commentId));

        comment.setContent(request.content());

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(UUID commentId) {
        commentRepository.deleteById(commentId);
    }
}
