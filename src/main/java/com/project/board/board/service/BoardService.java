package com.project.board.board.service;

import com.project.board.board.domain.Board;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;

    public void save(int groupId, BoardSaveForm boardSaveForm){
        Board saveBoard = Board.save(groupId, boardSaveForm);

    }
}
