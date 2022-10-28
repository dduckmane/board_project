package com.project.board.reply.repository;

import com.project.board.reply.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyRepositoryCustom {
    Page<Reply>searchAll(Long boardId,Pageable pageable);
}
