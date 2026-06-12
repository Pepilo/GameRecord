package com.pdg.backed.mapper.impl;

import org.springframework.stereotype.Controller;

import com.pdg.backed.domain.CreateCommentRequest;
import com.pdg.backed.domain.UpdateCommentRequest;
import com.pdg.backed.domain.dto.CommentDto;
import com.pdg.backed.domain.dto.CreateCommentRequestDto;
import com.pdg.backed.domain.dto.UpdateCommentRequestDto;
import com.pdg.backed.domain.entity.Comment;
import com.pdg.backed.mapper.CommentMapper;

@Controller
public class CommentMapperImpl implements CommentMapper{

    public CreateCommentRequest fromDto(CreateCommentRequestDto dto){
        return new CreateCommentRequest(
            dto.content()
        );
    };

    public UpdateCommentRequest fromDto(UpdateCommentRequestDto dto){
        return new UpdateCommentRequest(
            dto.content()
        );
    };

    public CommentDto toDto(Comment comment){
        return new CommentDto(
            comment.getCommentId(),
            comment.getContent(),
            comment.getCreated(),
            comment.getUpdated()
        );
    }

}
