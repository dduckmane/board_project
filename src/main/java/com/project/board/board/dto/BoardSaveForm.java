package com.project.board.board.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardSaveForm {
    private String title;
    private String content;
    private MultipartFile thumbNail;
}
