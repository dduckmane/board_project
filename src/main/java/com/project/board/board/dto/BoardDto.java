package com.project.board.board.dto;

import com.project.board.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private String subTitle;
    private Long viewCnt;
    private String username;
    private Boolean newArticle;


    public BoardDto(Board board) {
        this.subTitle = board.substringTitle();
        this.viewCnt = board.getViewCnt();
        this.username = board.getMember().getUsername();
        this.newArticle=board.checkNewArticle();
    }

}
