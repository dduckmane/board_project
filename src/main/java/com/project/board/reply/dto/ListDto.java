package com.project.board.reply.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ListDto {
    private int nowPage;
    private int endPage;
    private int startPage;
    private Page<ReplyDto> results;

    public ListDto(int nowPage, int endPage, int startPage, Page<ReplyDto> results) {
        this.nowPage = nowPage;
        this.endPage = endPage;
        this.startPage = startPage;
        this.results=results;
    }
}
