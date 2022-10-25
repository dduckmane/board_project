package com.project.board.board.domain;

import com.project.board.base.BaseEntity;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.member.domain.Member;
import com.project.board.reply.domain.Reply;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long id;
    private String title;
    private String content;
    private int groupId;
    private Long viewCnt;
    @OneToMany(mappedBy = "board")
    private List<Reply>replies=new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ElementCollection
    private List<String>fileNames=new ArrayList<>();

    public Board(String title){
        this.title=title;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }

    public void setReplies(Reply reply) {
        replies.add(reply);
        reply.setBoard(this);
    }
    public static Board save(int groupId,BoardSaveForm saveForm){
        Board board = new Board();
        board.title=saveForm.getTitle();
        board.content=saveForm.getContent();
        return board;
    }

    private String substringTitle(Board b) {

        // 만약에 글제목이 5글자 이상이라면
        // 5글자만 보여주고 나머지는 ...처리
        String title = b.getTitle();
        if (title.length() > 5) {
            String subStr = title.substring(0, 5);
            return subStr+"...";
        } else {
            return title;
        }

    }
    public Boolean checkNewArticle() {
        LocalDateTime newArticleDate = this.getCreatedDate().plusMinutes(5);
        return LocalDateTime.now().isAfter(newArticleDate);

    }
    public void changeDateFormat(){
        this.getLastModifiedDate().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
    }



}