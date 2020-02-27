package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageUtil;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/listJSON")
	@ResponseBody
	public List<BoardVO> lsitJson(PageDTO dto){
		return service.getPageList(dto);
	}
	
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pageDTO") PageDTO dto, Model model) {
		log.info("board...list......");
		log.info(" ==dto== : "+dto);
		log.info(" ==service== : "+service);
		model.addAttribute("sample", "Hello List");
		model.addAttribute("list",service.getPageList(dto));
		model.addAttribute("pageUtil",new PageUtil(dto, service.getTotal()));
	}
	
	@GetMapping("/register")
	public void registerGET() {
		log.info("register.get.......");
	}
	
	
	@PostMapping("/register")
	public String registerPOST() {
		log.info("register.post.......");
		return "redirect:/board/list";
	}
	
	
	
	
}
