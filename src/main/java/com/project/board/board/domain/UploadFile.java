package com.project.board.board.domain;

import com.project.board.util.FileUtils;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Embeddable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFile {
    private String uploadFileName;
    private String storeFileName;
    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
    public static UploadFile createUploadFile(MultipartFile multipartFile,String uploadPath){
        String storeFileName = FileUtils.uploadFile(multipartFile, uploadPath);

        String uploadFileName = multipartFile.getOriginalFilename();

        UploadFile uploadFile = new UploadFile(uploadFileName, storeFileName);

        return uploadFile;
    }

    public static List<UploadFile> storeFiles(List<MultipartFile> multipartFiles,String uploadPath) {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(createUploadFile(multipartFile,uploadPath));
            }
        }
        return storeFileResult;
    }
}
