package com.project.board.board;




import com.project.board.board.domain.Board;
import com.project.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;


import com.project.board.util.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class loadController {

    private final BoardRepository boardRepository;

    private static final String UPLOAD_PATH = "C:\\sl_dev\\upload";
    @ResponseBody
    @GetMapping(value ="/images", produces = MediaType.IMAGE_PNG_VALUE)
    public UrlResource downloadImage(@RequestParam Long itemId) throws
            MalformedURLException {
        log.info("-------------downloadImage 실행----------- {}");

        Board board = boardRepository.findById(itemId).orElseThrow();

        String storeFileName = board.getThumbNail().getStoreFileName();

        String fileFullPath = FileUtils.fileFullPath(storeFileName, UPLOAD_PATH);
        System.out.println("fileFullPath = " + fileFullPath);
        return new UrlResource("file:" + fileFullPath);
    }
}
