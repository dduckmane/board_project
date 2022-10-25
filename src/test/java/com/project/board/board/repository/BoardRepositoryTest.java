package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import com.project.board.board.search.BoardSearchCondition;
import com.project.board.member.domain.Member;
import com.project.board.reply.domain.Reply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    EntityManager em;
    
    @Test
    public void searchAll(){
        PageRequest pageRequest = PageRequest.of(0, 10);
        BoardSearchCondition boardSearchCondition = new BoardSearchCondition();
        Page<Board> boards = boardRepository.searchAllCondition(1, boardSearchCondition, pageRequest);
        for (Board board : boards) {
            System.out.println("board.getTitle() = " + board.getTitle());
        }
    }
}