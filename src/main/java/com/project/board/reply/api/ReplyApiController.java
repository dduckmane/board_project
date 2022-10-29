package com.project.board.reply.api;

import com.project.board.config.auth.PrincipalDetails;
import com.project.board.member.domain.Member;
import com.project.board.reply.dto.ReplyDto;
import com.project.board.reply.dto.ReplySaveDto;
import com.project.board.reply.dto.ReplyUpdateDto;
import com.project.board.reply.repository.ReplyRepository;
import com.project.board.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/reply")
public class ReplyApiController {
    private final ReplyService replyService;
    private final ReplyRepository replyRepository;

    @GetMapping("/list/{boardId}")
    public List<ReplyDto> list(@PathVariable Long boardId,@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<ReplyDto> results = replyRepository.searchAll(boardId, pageable).map(ReplyDto::new);

        int nowPage = results.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, results.getTotalPages());

        List<ReplyDto> content = results.getContent();
        return content;
    }
    @PostMapping("/{boardId}")
    public String save(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long boardId,@RequestBody ReplySaveDto replySaveDto){
        Member member = principalDetails.getMember();
        replyService.save(boardId,member, replySaveDto.getReplyText());
        return "save";
    }
    @PutMapping("/{replyId}")
    public String update(@PathVariable Long replyId, @RequestBody ReplyUpdateDto replyUpdateDto){
        replyService.update(replyId, replyUpdateDto.getReplyText());
        return "hello";
    }

}
