package com.project.board.board.dto;

import com.project.board.board.domain.BoardFiles;
import lombok.Data;

@Data
public class BoardFilesDto {
    private Long boardFilesId;
    private String uploadFileName;

    public BoardFilesDto(BoardFiles boardFiles) {
        this.boardFilesId = boardFiles.getId();
        this.uploadFileName = boardFiles.getAttachFiles().getUploadFileName();
    }
}
