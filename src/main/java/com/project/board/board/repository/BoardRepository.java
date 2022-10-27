package com.project.board.board.repository;

import com.project.board.board.domain.Board;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long>,BoardRepositoryCustom {

}

