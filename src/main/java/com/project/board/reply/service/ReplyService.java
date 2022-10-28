package com.project.board.reply.service;

import com.project.board.board.domain.Board;
import com.project.board.board.repository.BoardRepository;
import com.project.board.member.domain.Member;
import com.project.board.reply.domain.Reply;
import com.project.board.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    @Transactional
    public void save(Long boardId, Member member,String replyText){
        Board board = boardRepository.findById(boardId).orElseGet(() -> new Board());
        Reply reply = Reply.write(replyText, board, member);
        replyRepository.save(reply);
    }
    @Transactional
    public void update(Long replyId,String replyText){
        Reply reply = replyRepository.findById(replyId).orElseGet(() -> new Reply());
        reply.update(replyText);
    }

}
