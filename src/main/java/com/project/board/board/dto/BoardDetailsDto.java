package com.project.board.board.dto;

import com.project.board.board.domain.Board;
import com.project.board.board.domain.UploadFile;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BoardDetailsDto {
    private Long id;
    private String title;
    private String content;
    private Long viewCnt;
    private String username;
    private String createTime;

//    private List<UploadFile>uploadFiles;

//    private Long boardFilesId;
    private List<BoardFilesDto> boardFilesDto;

    public BoardDetailsDto(){

    }

    public BoardDetailsDto(Board board) {
        this.id=board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.viewCnt = board.getViewCnt();
        this.username = board.getMember().getUsername();
        this.createTime = board.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.boardFilesDto = board.getAttachFiles().stream().map(BoardFilesDto::new).collect(Collectors.toList());
    }
}
