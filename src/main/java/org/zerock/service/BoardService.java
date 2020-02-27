package org.zerock.service;

import java.util.List;

import org.zerock.dto.PageDTO;
import org.zerock.vo.BoardVO;

public interface BoardService {

	//리스트
	public List<BoardVO> getPageList(PageDTO dto);
	
	
	//등록
	public void register(BoardVO vo) ;
	
	//페이징
	public int getTotal();
	
	
	
	
}
