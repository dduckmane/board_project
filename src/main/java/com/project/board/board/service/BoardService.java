package com.project.board.board.service;

import com.project.board.board.domain.Board;
import com.project.board.board.domain.BoardFiles;
import com.project.board.board.domain.UploadFile;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final EntityManager em;

    @Transactional
    public void save(Member member, int groupId, String title, String content, UploadFile thumbNail, List<UploadFile>uploadFiles){
        List<BoardFiles> attachFiles = uploadFiles.stream().map(BoardFiles::new).collect(Collectors.toList());

        Board saveBoard = Board.write(member, groupId, title, content,thumbNail,attachFiles);

        boardRepository.save(saveBoard);

        saveBoard.getAttachFiles().stream().forEach(boardFiles -> {
            log.info("boardFiles.getAttachFiles().getUploadFileName()={}",boardFiles.getAttachFiles().getUploadFileName());
        });
    }

    @Transactional
    public void update(Long boardId, String content) {
        //optional처리 부분 질문
        Board board = boardRepository.findById(boardId).orElseGet(null);
        board.update(content);
    }
    @Transactional
    public void delete(Long boardId){
        Board board = boardRepository.findById(boardId).orElseGet(() -> new Board());
        boardRepository.delete(board);
    }
    @Transactional
    public Optional<Board> findOne(Long boardId, HttpServletResponse response, HttpServletRequest request){
        log.info("find {}_ board",boardId);
        Board board = boardRepository.findById(boardId).orElseThrow();
        System.out.println("board.getId()+ = " + board.getId()+"그리고"+board.getTitle());
        board.getAttachFiles().stream().forEach(boardFiles -> {
            System.out.println("findOne 실행");
            System.out.println("boardFiles.getAttachFiles().getUploadFileName() = " + boardFiles.getAttachFiles().getUploadFileName());
        });
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
