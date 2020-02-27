package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.dto.PageDTO;
import org.zerock.mapper.BoardMapper;
import org.zerock.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor // 오토와이어드 안써도됨 스프링 4버젼
public class BoardServieImpl implements BoardService{
	
	
	private BoardMapper mapper;

	
	@Override
	public List<BoardVO> getPageList(PageDTO dto) {
		return mapper.getList(dto);
	}
	
	

	@Override
	public void register(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
	}



	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}




}
