package com.project.board.board.domain;

import javax.persistence.*;

@Entity
public class BoardPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BoardPhoto_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private UploadFile ckEditorPhoto;
}
