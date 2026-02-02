package org.hdcd.board;

import java.time.LocalDateTime;

import org.hdcd.board.Board;
import org.hdcd.board.BoardService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/register")
	public String registerForm() {
		
		return "board/register";
		
	}
	
	
	@PostMapping("/input")
	@ResponseBody
	public String input(Board board) throws Exception {
		board.setRegDate(LocalDateTime.now());
		board.setModDate(LocalDateTime.now());
		
		boardService.register(board);
		
		return "OK";
	}
	
	@GetMapping("/list")
	public void boardList(@RequestParam(defaultValue = "1") int page, Model model) throws Exception {
		
		 int pageSize = 10; // 페이지당 게시글 수
		 int totalElements = boardService.getTotalCount();
		 int totalPages = (int) Math.ceil((double) totalElements / pageSize);
		 int startPage = ((page - 1) / 5) * 5 + 1; // 페이지 범위 시작 (5개씩 표시)
		 int endPage = Math.min(startPage + 4, totalPages); // 페이지 범위 끝
		    
		 model.addAttribute("list", boardService.selectList(page, pageSize));
		 model.addAttribute("currentPage", page);
		 model.addAttribute("totalPages", totalPages);
		 model.addAttribute("totalElements", totalElements);
		 model.addAttribute("pageSize", pageSize);
		 model.addAttribute("startPage", startPage);
		 model.addAttribute("endPage", endPage);
		 model.addAttribute("startRow", (page - 1) * pageSize + 1);
		 model.addAttribute("endRow", Math.min(page * pageSize, totalElements));
	}
	
	@GetMapping("/content")
    public String read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {

        Board board = boardService.selectOne(boardNo);

        // 게시글이 없을 때(삭제됐거나 use_yn='N' 등)
        if (board == null) {
            return "redirect:/board/list";
        }
        
        boardService.viewCount(boardNo);

        model.addAttribute("board", board);
        return "board/content"; // resources/templates/board/read.html
    }
	
	@GetMapping("update")
	public String update(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		 Board board = boardService.selectOne(boardNo);
		 
		 // 게시글이 없을 때(삭제됐거나 use_yn='N' 등)
	        if (board == null) {
	            return "redirect:/board/list";
	        }

	        model.addAttribute("board", board);
	        return "board/update"; // resources/templates/board/read.html
		 
	}
	
	@PostMapping("/modify")
	@ResponseBody
	public String modify(Board board) throws Exception {
		board.setModDate(LocalDateTime.now());
		
		boardService.update(board);
		
		return "OK";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		boardService.delete(boardNo);
		
		return "redirect:/board/list";
	}
	
}
