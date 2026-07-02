package com.pdg.backed.mapper;

import com.pdg.backed.domain.comment.CreateCommentRequest;
import com.pdg.backed.domain.comment.UpdateCommentRequest;
import com.pdg.backed.domain.comment.dto.CommentDto;
import com.pdg.backed.domain.comment.dto.CreateCommentRequestDto;
import com.pdg.backed.domain.comment.entity.Comment;
import com.pdg.backed.domain.dto.UpdateCommentRequestDto;

public interface CommentMapper {

    CreateCommentRequest fromDto(CreateCommentRequestDto dto);

    UpdateCommentRequest fromDto(UpdateCommentRequestDto dto);

    CommentDto toDto(Comment comment);
}
