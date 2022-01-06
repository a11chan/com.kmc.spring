package org.zerock.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..........");
	}
	//http://localhost:8080/sample/ex01?name=allchan&age=35
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("SampleDTO: " + dto);
		
		return "/sample/ex01";
	}
	
	//http://localhost:8080/sample/ex02?ids=111&ids=222&ids=333
	@GetMapping("/ex02")
	public String ex02(@RequestParam("ids") ArrayList<String> ids) {
		//@RequestParam("ids")은 ids라는 이름으로 파라미터가 여러 개 전달되어도 자동으로 수집되게 함
		log.info("SampleDTO: " + ids);
		
		return "sample/ex02";
	}
	//http://localhost:8080/sample/ex03?list%5B0%5D.name=aaa&list%5B1%5D.name=bbb
	@GetMapping("/ex03")
	public String ex03(SampleDTOList list) {
		log.info("List: " + list);
		
		return "sample/ex03";
	}
	
	// http://localhost:8080/sample/ex04?title=test&dueDate=2022-01-03
	@GetMapping("/ex04")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		
		return "sample/ex04";
	}
	
	// http://localhost:8080/sample/ex05
	@GetMapping("/ex05")
	public String ex05(Model model) {
		// Model 객체: 데이터수집X, 화면전달O
		model.addAttribute("date", new Date());
		
		return "sample/ex05";
	}
	
	// http://localhost:8080/sample/ex06?name=aaa&age=11&page=9
	@GetMapping("/ex06")
	// @ModelAttribute("page")는 파라미터 값을 views까지 전달
	// 일반자료형 외에는 데이터수집O, 화면전달X
	public String ex05(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto" + dto);
		log.info("page" + page);
		
		return "sample/ex06";
	}
	
	/*
	@GetMapping("/ex07")
	public String ex07(BoardVO boardVO, RedirectAttributes rttr) {
		// service.register(boardVO);
		// RedirectAttributes: 데이터수집X, 화면전달O
		rttr.addFlashAttribute("name", "aaa");
		rttr.addFlashAttribute("age", "11");
		
		return "redirect:/";
	}
	*/
	
	@PostMapping("/exUpload")
	public void exUpload(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("/exUpload..........");
			log.info("name: "+ file.getOriginalFilename());
			log.info("name: "+ file.getSize());
		});
	}
}
