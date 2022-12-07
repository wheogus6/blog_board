package com.example.blog_board.service;

import com.example.blog_board.domain.Board;
import com.example.blog_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public int boardCount() throws Exception{
        return boardMapper.boardCount();
    }

    @Override
    public List<Board> boardList() throws Exception{
        return boardMapper.findAll();
    }

    @Override
    public Board findById(Long boardId) throws Exception{
        return boardMapper.findById(boardId);
    }

    @Transactional
    public Long add(Board board) throws Exception{
        return boardMapper.save(board);
    }

    @Transactional
    public int update(Board board) throws Exception {
        return boardMapper.update(board);
    }

    @Override
    public void deleteById(Long boardId) throws Exception {
        boardMapper.delete(boardId);
    }
}
