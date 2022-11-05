package com.project.board.board.domain;

import com.project.board.base.BaseEntity;
import com.project.board.board.dto.BoardSaveForm;
import com.project.board.board.dto.BoardUpdateForm;
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
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", nullable = false)
    private Long id;
    private String title;
    private String content;
    private int groupId;
    //질문
    private Long viewCnt=0L;
    @OneToMany(mappedBy = "board",orphanRemoval = true)
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
    public Board(){

    }
    public static Board write(Member member,int groupId,String title,String content){
        Board board = new Board();
        board.title=title;
        board.member=member;
        board.groupId=groupId;
        board.content=content;
        member.getBoards().add(board);
        return board;
    }
    public void update(String content){
        this.content=content;
    }

    public String substringTitle() {

        // 만약에 글제목이 5글자 이상이라면
        // 5글자만 보여주고 나머지는 ...처리
        String title = this.getTitle();
        if (title.length() > 5) {
            String subStr = title.substring(0, 5);
            return subStr+"...";
        } else {
            return title;
        }

    }
    public Boolean checkNewArticle() {
        LocalDateTime newArticleDate = this.getCreatedDate().plusMinutes(5);
        return LocalDateTime.now().isBefore(newArticleDate);

    }
    public void plusViewCnt(){
         this.viewCnt += 1;
    }



}