package com.project.board.reply.dto;

import com.project.board.reply.domain.Reply;
import lombok.Data;

import java.time.format.DateTimeFormatter;
@Data
public class ReplyDto {
    private String replyText;
    private String memberName;
    private String createDate;

    public ReplyDto(Reply reply) {
        this.replyText = reply.getReplyText();
        this.memberName = reply.getMember().getName();//이거 나중에 수정--> 시큐리티로 이용
        this.createDate = reply.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
