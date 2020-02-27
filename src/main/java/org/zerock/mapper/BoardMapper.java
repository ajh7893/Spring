package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.dto.PageDTO;
import org.zerock.vo.BoardVO;

public interface BoardMapper {
	
	
	public List<BoardVO> getList(PageDTO dto);
	
	@Select("select count(*) from tbl_board")
	public int getTotal();
	
	@Insert("insert into tbl_board(bno, title, content, writer)"
				+" values (seq_board.nextval, #{title}, #{content},#{writer})")
	public int insert(BoardVO vo);
	
	
}
