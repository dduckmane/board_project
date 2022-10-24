package com.project.board.board.domain;

import com.project.board.base.BaseEntity;
import com.project.board.member.domain.Member;
import com.project.board.reply.domain.Reply;
import lombok.*;

import javax.persistence.*;
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
    private boolean newArticle;
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

}