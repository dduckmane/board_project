package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
    Page<Board>searchForUsername(String username, Pageable pageable);
    Page<Board>searchByTitle(String title,Pageable pageable);
    Page<Board>searchByUsernameAndTitle(String text,Pageable pageable);
    Page<Board>searchAll(Pageable pageable);
}
