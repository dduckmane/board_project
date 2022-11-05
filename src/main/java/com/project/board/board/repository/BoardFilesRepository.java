package com.project.board.board.repository;

import com.project.board.board.domain.BoardFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFilesRepository extends JpaRepository<BoardFiles,Long> {
}
