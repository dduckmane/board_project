package com.project.board.board.service;

import com.project.board.board.domain.Board;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.dto.BoardUpdateForm;
import com.project.board.board.repository.BoardRepository;
import com.project.board.member.domain.Member;
import com.project.board.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.WebUtils;

import javax.persistence.EntityManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final EntityManager em;

    @Transactional
    public void save(Member member, int groupId, BoardSaveForm boardSaveForm){
        Board saveBoard = new Board(member, groupId, boardSaveForm);
        boardRepository.save(saveBoard);
    }

    @Transactional
    public void update(Long boardId, BoardUpdateForm boardUpdateForm) {
        //optional처리 부분 질문
        Board board = boardRepository.findById(boardId).orElseGet(()->new Board());
        board.update(boardUpdateForm);
    }
    @Transactional
    public void delete(Long boardId){
        Board board = boardRepository.findById(boardId).orElseGet(() -> new Board());
        boardRepository.delete(board);
    }
    @Transactional
    public Optional<Board> findOne(Long boardId, HttpServletResponse response, HttpServletRequest request){
        log.info("find {}_ board",boardId);
        Board board = boardRepository.findById(boardId).orElseGet(() -> new Board());
        makeViewCount(board,response,request);
        return Optional.ofNullable(board);
    }
    private void makeViewCount(Board board, HttpServletResponse response, HttpServletRequest request) {
        Cookie foundCookie = WebUtils.getCookie(request, "board_" + board.getId());

        if (foundCookie == null) {
            board.plusViewCnt();
            Cookie cookie = new Cookie("board_" + board.getId(), String.valueOf(board.getId()));// 쿠키 생성
            cookie.setMaxAge(60); // 쿠키 수명 설정
            cookie.setPath("/user/board/");
            response.addCookie(cookie);
        }
    }
}
