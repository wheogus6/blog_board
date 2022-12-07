package com.example.blog_board.mapper;

import com.example.blog_board.domain.Board;

import java.util.List;

public interface BoardMapper {
    int boardCount() throws Exception;

    List<Board> findAll() throws Exception;

    Board findById(Long boardId) throws Exception;

    Long save(Board board) throws Exception;

    int update(Board board) throws Exception;

    void delete(Long boardId) throws Exception;
}
