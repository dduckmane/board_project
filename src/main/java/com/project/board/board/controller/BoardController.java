package com.project.board.board.controller;

import com.project.board.board.domain.Board;
import com.project.board.board.dto.BoardDetailsDto;
import com.project.board.board.dto.BoardDto;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.dto.BoardUpdateForm;
import com.project.board.board.repository.BoardRepository;
import com.project.board.board.search.BoardSearchCondition;
import com.project.board.board.service.BoardService;
import com.project.board.config.auth.PrincipalDetails;
import com.project.board.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/{groupId}/list")
    public List<BoardDto> main(@PathVariable int groupId, BoardSearchCondition searchCondition,
                               @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<BoardDto> result = boardRepository.searchAllCondition(groupId, searchCondition, pageable).map(BoardDto::new);

        int nowPage = result.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, result.getTotalPages());
        List<BoardDto> content = result.getContent();

        return content;
    }
    @GetMapping("/{boardId}")
    public BoardDetailsDto board(@PathVariable Long boardId, HttpServletResponse response, HttpServletRequest request){
        BoardDetailsDto boardDetailsDto = boardService
                .findOne(boardId, response, request)
                .map(BoardDetailsDto::new).orElseGet(() -> new BoardDetailsDto());
        return boardDetailsDto;
    }
    @GetMapping("/save")
    public String saveForm(){
        return "saveForm";
    }

    @PostMapping("/save")
    public String save(@AuthenticationPrincipal PrincipalDetails principalDetails, RedirectAttributes redirectAttributes){

        //임의 saveFORM을 만듦
        BoardSaveForm boardSaveForm = new BoardSaveForm();
        boardSaveForm.setContent("prac");
        boardSaveForm.setTitle("title");
        //임의 saveFORM을 만듦

        Member member = principalDetails.getMember();

        boardService.save(member,1,boardSaveForm.getTitle(),boardSaveForm.getContent());
        return "hello";
    }
    @GetMapping("{boardId}/edit")
    public String editForm(){
        return "editForm";
    }
    @PostMapping("{boardId}/edit")
    public String edit(@AuthenticationPrincipal PrincipalDetails principalDetails,@PathVariable Long boardId){
        //임의의 updateForm
        BoardUpdateForm boardUpdateForm = new BoardUpdateForm();
        boardUpdateForm.setContext("parar");
        boardService.update(boardId,boardUpdateForm.getContext());
        return "update";
    }
    @GetMapping("{boardId}/delete")
    //물어보기 외래키 제약조건??
    public String delete(@PathVariable Long boardId){
        boardService.delete(boardId);
        return "delete";
    }
}
