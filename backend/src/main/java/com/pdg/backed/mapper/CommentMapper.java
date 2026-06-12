package com.pdg.backed.mapper;

import com.pdg.backed.domain.CreateCommentRequest;
import com.pdg.backed.domain.UpdateCommentRequest;
import com.pdg.backed.domain.dto.CommentDto;
import com.pdg.backed.domain.dto.CreateCommentRequestDto;
import com.pdg.backed.domain.dto.UpdateCommentRequestDto;
import com.pdg.backed.domain.entity.Comment;

public interface CommentMapper {

    CreateCommentRequest fromDto(CreateCommentRequestDto dto);

    UpdateCommentRequest fromDto(UpdateCommentRequestDto dto);

    CommentDto toDto(Comment comment);
}
