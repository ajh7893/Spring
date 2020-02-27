package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.dto.PageDTO;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/data/*")
@AllArgsConstructor
public class BoardRESTController {
	

	private BoardService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<BoardVO>> getList(PageDTO dto){
	
		//모델 jsp에 출력할때 
		List<BoardVO> list = service.getPageList(dto);
		return new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);//200 headermasage까지 보낼수있다..
		
	}
	
	//2.
	//등록조회? //게시판 조회 //json data만 
	//chrome-extension://ehafadccdcdedbhcbddihehiodgcddpl/index.html JSON데이터 던저보기
	@PostMapping("/new")
	public ResponseEntity<String> register(@RequestBody BoardVO vo){
		
		log.info("vo : " + vo);
		service.register(vo);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	//1.
	//조회
	//수집
	@GetMapping("/{bno}")
	public ResponseEntity<BoardVO> get(@PathVariable("bno") Integer bno){
		//bno번호가 따지는지?		//http://localhost:8080/data/10
		log.info("get.................");
		log.info("bno : "+bno);
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
}