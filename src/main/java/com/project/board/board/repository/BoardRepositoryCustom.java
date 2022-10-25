package com.project.board.board.repository;

import com.project.board.board.domain.Board;
import com.project.board.board.search.BoardSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    Page<Board>searchAllCondition(int groupId,BoardSearchCondition searchCondition,Pageable pageable);
}
