package com.project.board.board.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardFiles_id", nullable = false)
    private Long id;

    private UploadFile attachFiles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    public Board board;

    public BoardFiles(UploadFile attachFiles) {
        this.attachFiles = attachFiles;
    }
}
