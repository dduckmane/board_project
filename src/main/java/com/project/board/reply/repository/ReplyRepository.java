package com.project.board.reply.repository;

import com.project.board.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long>,ReplyRepositoryCustom{

}
