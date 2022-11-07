package com.project.board.board.controller;

import com.project.board.board.domain.UploadFile;
import com.project.board.board.dto.BoardDetailsDto;
import com.project.board.board.dto.BoardDto;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.dto.BoardUpdateForm;
import com.project.board.board.repository.BoardRepository;
import com.project.board.board.search.BoardSearchCondition;
import com.project.board.board.service.BoardService;
import com.project.board.config.auth.PrincipalDetails;
import com.project.board.member.domain.Member;
import com.project.board.page.PageMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    private static final String UPLOAD_PATH = "C:\\sl_dev\\upload";

    @GetMapping("/list/{groupId}")
    public String list(@PathVariable int groupId, BoardSearchCondition searchCondition,
                               @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Model model){

        log.info("/user/board/list/{} GET",groupId);

        Page<BoardDto> result = boardRepository.searchAllCondition(groupId, searchCondition, pageable).map(BoardDto::new);

        //pageMaker 생성
        int nowPage = result.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, result.getTotalPages());

        PageMaker pageMaker = new PageMaker(nowPage, endPage, startPage, result.isFirst(), result.isLast(), result.getTotalPages());
        model.addAttribute("pageMaker",pageMaker);

        //content 생성
        List<BoardDto> content = result.getContent();
        model.addAttribute("BoardDtoList",content);

        model.addAttribute("groupId",groupId);

        return "board/board-list";
    }
    @GetMapping("/{boardId}")
    public String details(@PathVariable Long boardId,@AuthenticationPrincipal PrincipalDetails principalDetails, HttpServletResponse response, HttpServletRequest request,Model model){

        log.info("/user/board/{} GET",boardId);

        //권한 처리
        boolean checkWriter=boardService.checkWriter(principalDetails.getMember());;
        model.addAttribute("checkWriter",checkWriter);

        BoardDetailsDto boardDetailsDto = boardService
                .findOne(boardId, response, request)
                .map(BoardDetailsDto::new).orElseThrow();//예외를 만들어야 하나??

        model.addAttribute("boardDetailsDto",boardDetailsDto);

        return "board/board-detail";
    }
    @GetMapping("/save/{groupId}")
    public String saveForm(@PathVariable int groupId,Model model){

        log.info("/user/board/save/{} GET",groupId);

        model.addAttribute("groupId",groupId);

        return "board/board-write";
    }

    @PostMapping("/save/{groupId}")
    public String save(@AuthenticationPrincipal PrincipalDetails principalDetails, @ModelAttribute BoardSaveForm boardSaveForm,@PathVariable int groupId, RedirectAttributes redirectAttributes){

        log.info("/user/board/save/{} POST",groupId);

        Member member = principalDetails.getMember();

        UploadFile uploadFile = UploadFile.createUploadFile(boardSaveForm.getThumbNail(), UPLOAD_PATH);
        List<UploadFile> uploadFiles = UploadFile.storeFiles(boardSaveForm.getAttachFiles(), UPLOAD_PATH);

        boardService.save(member,groupId,boardSaveForm.getTitle(),boardSaveForm.getContent(),uploadFile,uploadFiles);

        return "redirect:/user/board/list/{groupId}";
    }
    @GetMapping("/edit/{boardId}")
    public String editForm(@PathVariable Long boardId,@AuthenticationPrincipal PrincipalDetails principalDetails, Model model,RedirectAttributes redirectAttributes) {

        log.info("/user/board/edit/{} GET",boardId);

        BoardUpdateForm BoardUpdateForm = boardRepository.findById(boardId).map(BoardUpdateForm::new).orElseThrow();
        model.addAttribute("BoardUpdateForm",BoardUpdateForm);

        return boardService.checkWriter(principalDetails.getMember()) ? "board/board-modify" : "redirect:/";
    }
    @PostMapping("/edit/{boardId}")
    public String edit(@PathVariable Long boardId,@ModelAttribute BoardUpdateForm boardUpdateForm,RedirectAttributes redirectAttributes){

        log.info("/user/board/edit/{} POST",boardId);

        boardService.update(boardId,boardUpdateForm.getContent());

        return "redirect:/user/board/{boardId}";
    }
    @GetMapping("/delete/{boardId}")
    public String delete(@PathVariable Long boardId,RedirectAttributes redirectAttributes){

        log.info("/user/board/delete/{} GET",boardId);

        boardService.delete(boardId);

        return "redirect:/";
    }
}
