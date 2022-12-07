package com.example.blog_board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder

@AllArgsConstructor
public class Board {   // board DTO 가능
    private long boardId;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private Integer read;
    private String name;

    private Long memberId;

    public Board(){}
    public Board(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

}

