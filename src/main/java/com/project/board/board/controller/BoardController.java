package com.project.board.board.controller;

import com.project.board.board.domain.Board;
import com.project.board.board.repository.BoardRepository;
import com.project.board.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String index(){
        Board board = boardRepository.findById(1L).get();
        Member member = board.getMember();
        System.out.println("member = " + member);
        return "hello";
    }
}
