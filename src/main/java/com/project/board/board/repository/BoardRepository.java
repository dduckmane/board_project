package com.project.board.board.repository;

import com.project.board.board.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>,BoardRepositoryCustom {
}

