package org.zerock.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//http://localhost:8080/sample/ex04?title=test&dueDate=2022-01-03
	@GetMapping("/ex04")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		
		return "sample/ex04";
	}
}
