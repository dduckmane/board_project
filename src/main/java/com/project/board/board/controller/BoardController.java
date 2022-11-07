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
@Log4j2
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    private static final String UPLOAD_PATH = "C:\\sl_dev\\upload";

    @GetMapping("/list/{groupId}")
    public String main(@PathVariable int groupId, BoardSearchCondition searchCondition,
                               @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable, Model model){
        Page<BoardDto> result = boardRepository.searchAllCondition(groupId, searchCondition, pageable).map(BoardDto::new);


        System.out.println("result.getTotalPages() = " + result.getTotalPages());
        
        int nowPage = result.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, result.getTotalPages());

        List<BoardDto> content = result.getContent();
        model.addAttribute("BoardDtoList",content);
        model.addAttribute("groupId",groupId);

        PageMaker pageMaker = new PageMaker(nowPage, endPage, startPage, result.isFirst(), result.isLast(), result.getTotalPages());
        model.addAttribute("pageMaker",pageMaker);

        return "board/board-list";
    }
    @GetMapping("/{boardId}")
    public String board(@PathVariable Long boardId, HttpServletResponse response, HttpServletRequest request,Model model){
        BoardDetailsDto boardDetailsDto = boardService
                .findOne(boardId, response, request)
                .map(BoardDetailsDto::new).orElseThrow();

        model.addAttribute("boardDetailsDto",boardDetailsDto);

        return "board/board-detail";
    }
    @GetMapping("/save/{groupId}")
    public String saveForm(@PathVariable int groupId,Model model){
        model.addAttribute("groupId",groupId);
        return "board/board-write";}

    @PostMapping("/save/{groupId}")
    public String save(@AuthenticationPrincipal PrincipalDetails principalDetails, @ModelAttribute BoardSaveForm boardSaveForm,@RequestParam int groupId, RedirectAttributes redirectAttributes){

        log.info("/user/board/save POST");
        Member member = principalDetails.getMember();

        UploadFile uploadFile = UploadFile.createUploadFile(boardSaveForm.getThumbNail(), UPLOAD_PATH);

        List<UploadFile> uploadFiles = UploadFile.storeFiles(boardSaveForm.getAttachFiles(), UPLOAD_PATH);

        boardService.save(member,groupId,boardSaveForm.getTitle(),boardSaveForm.getContent(),uploadFile,uploadFiles);
        return "redirect:/user/board/list/{groupId}";
    }
    @GetMapping("/edit/{boardId}")
    public String editForm(@PathVariable Long boardId,Model model)

    {
        BoardUpdateForm BoardUpdateForm = boardRepository.findById(boardId).map(BoardUpdateForm::new).orElseGet(() -> new BoardUpdateForm());
        model.addAttribute("BoardUpdateForm",BoardUpdateForm);
        return "board/board-modify";
    }
    @PostMapping("/edit/{boardId}")
    public String edit(@AuthenticationPrincipal PrincipalDetails principalDetails,@RequestParam Long boardId,@ModelAttribute BoardUpdateForm boardUpdateForm,RedirectAttributes redirectAttributes){
        //들어온 사람이 boardId를 작성하기 않았으면 돌려보내줘야하는 코드를 서버에서도 알려줘야하고
        //클라이언트로도 true와 false를 넘겨줘야한다.
        boardService.update(boardId,boardUpdateForm.getContent());
        return "redirect:/user/board/{boardId}";
    }
    @GetMapping("/delete/{boardId}")
    //물어보기 외래키 제약조건??
    public String delete(@PathVariable Long boardId,RedirectAttributes redirectAttributes){
        boardService.delete(boardId);
        return "redirect:/";
    }
}
