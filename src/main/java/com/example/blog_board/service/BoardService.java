package com.example.blog_board.service;

import com.example.blog_board.domain.Board;

import java.util.List;

public interface BoardService {

    /* TODO */
    // BoardService를 implement 하여 BoardService 클래스 생성
    // BoardMapper를 참고

    public int boardCount() throws Exception;
    public List<Board> boardList() throws Exception;

    public Board findById(Long boardId) throws Exception;

    public Long add(Board board) throws Exception;

    public int update(Board board) throws Exception;
    public void deleteById(Long boardId) throws Exception;

}
