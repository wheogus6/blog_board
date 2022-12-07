package com.example.blog_board.mapper;

import com.example.blog_board.domain.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardMapperImpl  implements BoardMapper{
    @Autowired
    private SqlSession session;
    private static String namespace = "com.example.blog_board.mapper.BoardMapper.";



    @Override
    public int boardCount() throws Exception {
        return session.selectOne(namespace + "boardCount");
    }

    @Override
    public List<Board> findAll() throws Exception {
        return session.selectList(namespace + "findAll");
    }

    @Override
    public Board findById(Long boardId) throws Exception {
        return session.selectOne(namespace + "findById");
    }

    @Override
    public Long save(Board board) throws Exception {
        return Long.valueOf(session.insert(namespace + "save"));
    }

    @Override
    public int update(Board board) {
        return session.update(namespace + "update", board);
    }

    @Override
    public void delete(Long boardId) {
        session.delete(namespace + "delete");
    }
}
