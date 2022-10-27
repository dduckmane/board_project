package com.project.board.board.dto;

import com.project.board.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class BoardDetailsDto {
    private String title;
    private String content;
    private Long viewCnt;
    private String username;
    private String createTime;
//    private 첨부파일

    public BoardDetailsDto(){

    }

    public BoardDetailsDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.viewCnt = board.getViewCnt();
        this.username = board.getMember().getUsername();
        this.createTime = board.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
