package com.example.blog_board.controller;

import com.example.blog_board.domain.Board;
import com.example.blog_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/hello")
    public String Hello(){
        return "/board/hello";
    }

    @GetMapping("/test")
    public String test(Model model) throws Exception{
        int boardCount = boardService.boardCount();
        List<Board> boardList = boardService.boardList();

        model.addAttribute("cnt", boardCount);
        model.addAttribute("test", boardList);

        return "/board/hello";
    }

    @GetMapping("/list")
    public String main(Model model) throws Exception{
        List<Board> boards = boardService.boardList();
        /* TODO board 리스트 조회 구현 */
        model.addAttribute("boards", boards);

        return "/board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable long boardId, Model model) throws Exception{
        Board board = boardService.findById(boardId);
                /* TODO board id로 board 조회 */
        model.addAttribute("board", board);

        return "/board/board";
    }

    @GetMapping("/add")
    public String add(){
        return "/board/addForm";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String content,
                      @RequestParam String name, RedirectAttributes redirectAttributes) throws Exception {
        Board addBoard = new Board(title, content, name);
        Long boardId = boardService.add(addBoard);


        redirectAttributes.addAttribute("boardId", boardId);
        redirectAttributes.addAttribute("status", true);

        return "redirect:/boards/{boardId}";
    }


    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model)throws Exception{
        Board findBoard = boardService.findById(boardId);

                /* TODO 수정 작업 전에 board id로 기존 board 조회 */
        model.addAttribute("board", findBoard);

        return "board/editForm";
    }

    @PostMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, @RequestParam String title, @RequestParam String content, @RequestParam String name) throws Exception {

        Board findBoard = boardService.findById(boardId);   //객체 만들어서 title, content, name 값 얻기
        findBoard.setTitle(title);
        findBoard.setContent(content);
        findBoard.setName(name);

        /* TODO 수정 작업 board 속성 값을 받아 board 업데이트 */
        boardService.update(findBoard);      // 위 findBoard 값 업데이트

        return "redirect:/boards/{boardId}";
    }

    @GetMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId) throws Exception {
        boardService.deleteById(boardId);
        /* TODO board id에 해당하는 board 삭제 */

        return "redirect:/boards";
    }


}
