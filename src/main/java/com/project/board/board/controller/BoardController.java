package com.project.board.board.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/{groupId}/list")
    public String main(@PathVariable int groupId, BoardSearchCondition searchCondition,
                               @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Model model){
        Page<BoardDto> result = boardRepository.searchAllCondition(groupId, searchCondition, pageable).map(BoardDto::new);

        int nowPage = result.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, result.getTotalPages());

        List<BoardDto> content = result.getContent();
        model.addAttribute("BoardDtoList",content);
        return "board/board-list";
    }
    @GetMapping("/{boardId}")
    public String board(@PathVariable Long boardId, HttpServletResponse response, HttpServletRequest request,Model model){
        BoardDetailsDto boardDetailsDto = boardService
                .findOne(boardId, response, request)
                .map(BoardDetailsDto::new).orElseGet(() -> new BoardDetailsDto());
        model.addAttribute("boardDetailsDto",boardDetailsDto);
        return "/WEB-INF/views/board/board-detail.jsp";
    }
    @GetMapping("/save")
    public String saveForm(){
        return "board/board-write";
    }

    @PostMapping("/save")
    public String save(@AuthenticationPrincipal PrincipalDetails principalDetails, @ModelAttribute BoardSaveForm boardSaveForm,RedirectAttributes redirectAttributes){

        Member member = principalDetails.getMember();
        boardService.save(member,1,boardSaveForm.getTitle(),boardSaveForm.getContent());
        return "redirect: board/board-detail";
    }
    @GetMapping("{boardId}/edit")
    public String editForm(@ModelAttribute BoardSaveForm boardSaveForm)
    {
        return "board/board-modify";
    }
    @PostMapping("{boardId}/edit")
    public String edit(@AuthenticationPrincipal PrincipalDetails principalDetails,@PathVariable Long boardId,@ModelAttribute BoardUpdateForm boardUpdateForm,RedirectAttributes redirectAttributes){
        //들어온 사람이 boardId를 작성하기 않았으면 돌려보내줘야하는 코드를 서버에서도 알려줘야하고
        //클라이언트로도 true와 false를 넘겨줘야한다.
        boardService.update(boardId,boardUpdateForm.getContext());
        return "redirect: board/board-detail";
    }
    @GetMapping("{boardId}/delete")
    //물어보기 외래키 제약조건??
    public String delete(@PathVariable Long boardId,RedirectAttributes redirectAttributes){
        boardService.delete(boardId);
        return "redirect: /";
    }
}
