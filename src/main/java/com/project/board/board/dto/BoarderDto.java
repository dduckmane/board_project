package com.project.board.board.dto;

import com.project.board.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoarderDto {
    private String title;
    private String content;
    private Long viewCnt;
    private String username;
    private LocalDateTime localDateTime;
//    private 첨부파일


    public BoarderDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.viewCnt = board.getViewCnt();
        this.username = board.getMember().getUsername();
        this.localDateTime=board.getLastModifiedDate();
    }
}
