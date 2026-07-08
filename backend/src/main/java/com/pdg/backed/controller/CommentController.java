package com.pdg.backed.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.backed.domain.comment.CreateCommentRequest;
import com.pdg.backed.domain.comment.UpdateCommentRequest;
import com.pdg.backed.domain.comment.dto.CommentDto;
import com.pdg.backed.domain.comment.dto.CreateCommentRequestDto;
import com.pdg.backed.domain.comment.entity.Comment;
import com.pdg.backed.domain.dto.UpdateCommentRequestDto;
import com.pdg.backed.mapper.CommentMapper;
import com.pdg.backed.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentController (CommentService commentService, CommentMapper commentMapper){
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(
        @Valid
        @RequestBody
        CreateCommentRequestDto createCommentRequestDto
    ) {
        CreateCommentRequest createCommentRequest = commentMapper.fromDto(createCommentRequestDto);
        Comment comment = commentService.createComment(createCommentRequest);
        CommentDto createCommentDto = commentMapper.toDto(comment);
        return new ResponseEntity<>(createCommentDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments() {
        List<Comment> comments = commentService.getComments();
        List<CommentDto> commentDtos = comments.stream().map(commentMapper::toDto).toList();
        return ResponseEntity.ok(commentDtos);
    }

    @PutMapping(path = "/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
        @PathVariable UUID commentId,
        @Valid
        @RequestBody
        UpdateCommentRequestDto updateCommentRequestDto
    ) {
        UpdateCommentRequest updateCommentRequest = commentMapper.fromDto(updateCommentRequestDto);
        Comment comment = commentService.updateComment(commentId, updateCommentRequest);
        CommentDto CommentDto = commentMapper.toDto(comment);
        return ResponseEntity.ok(CommentDto);
    }

    @DeleteMapping(path = "/{commentId}")
    public ResponseEntity<Void> deleteComment(
        @PathVariable UUID commentId
    ) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
