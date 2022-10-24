package com.project.board.member.domain;

import com.project.board.board.domain.Board;
import com.project.board.base.BaseTimeEntity;
import com.project.board.reply.domain.Reply;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String account;
    private String password;
    private String username;
    private String email;
    @OneToMany(mappedBy = "member")
    List<Reply>replies=new ArrayList<>();
    @OneToMany(mappedBy = "member")
    List<Board>boards=new ArrayList<>();

    public Member(String username){
        this.username=username;
    }

}
