package com.project.board.board.controller;

import com.project.board.board.domain.Board;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.dto.BoarderDto;
import com.project.board.board.repository.BoardRepository;
import com.project.board.board.search.BoardSearchCondition;
import com.project.board.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/{groupId}")
    public List<BoarderDto> main(@PathVariable int groupId, BoardSearchCondition searchCondition,
                            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<BoarderDto> result = boardRepository.searchAllCondition(groupId, searchCondition, pageable).map(BoarderDto::new);

        int nowPage = result.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, result.getTotalPages());
        List<BoarderDto> content = result.getContent();

        return content;
    }
//    @PostMapping("/{gropId}")
//    public String save(@ModelAttribute BoardSaveForm saveForm, RedirectAttributes redirectAttributes){
//
//    }
}
