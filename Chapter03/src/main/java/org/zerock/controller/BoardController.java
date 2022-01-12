package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",service.getList());
	} // return이 없어도 view로 다시 보냄 void는 결과를 요청URL로 보냄
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// └>사용자가 등록한 게시물이 BoardVO로 수집됨
		service.register(board);
		log.info("register: " + board);
		rttr.addFlashAttribute("result", board.getBno()); //(KEY, Value)
		// └>등록작업이 끝난 후 목록으로 돌아가면서 일회성 데이터 전달용
		
		return "redirect:/board/list";
		// redirect:새로고침에 의한 재등록 방지 -> list 페이지로 포워딩
	}
	
	@GetMapping("/read")
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("/read");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		
		if ( service.modify(board) ) {
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
}
