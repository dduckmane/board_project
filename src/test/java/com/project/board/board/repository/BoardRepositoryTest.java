package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import com.project.board.member.domain.Member;
import com.project.board.member.repository.MemberRepository;
import com.project.board.reply.domain.Reply;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    EntityManager em;

    @BeforeEach
    public void init(){
        for (int i = 1; i <=4; i++) {
            Member member = new Member(String.valueOf(i));
            em.persist(member);
                for (int j = 1; j <=4 ; j++) {
                    Board board = new Board(String.valueOf(i));
                    board.setMember(member);
                    em.persist(board);
                        for (int k = 1; k <=3 ; k++) {
                            Reply reply = new Reply(String.valueOf(i));
                            reply.setBoard(board);
                            reply.setMember(member);
                            em.persist(reply);
                        }
            }
        }
        em.flush();
        em.clear();

    }

    @Test
    public void searchByUsername(){
        PageRequest pageable = PageRequest.of(0, 100);
//        PageRequest pageable = PageRequest.of(0, 100,Sort.by());
        Page<Board> results = boardRepository.searchForUsername("1", pageable);
        for (Board result : results) {
            System.out.println("result = " + result);
        }
    }
}