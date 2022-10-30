package com.project.board.board.dto;

import com.project.board.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String subTitle;
    private Long viewCnt;
    private String name;
    private Boolean newArticle;


    public BoardDto(Board board) {
        this.id=board.getId();
        this.subTitle = board.substringTitle();
        this.viewCnt = board.getViewCnt();
        this.name = board.getMember().getName();
        this.newArticle=board.checkNewArticle();
    }

}
