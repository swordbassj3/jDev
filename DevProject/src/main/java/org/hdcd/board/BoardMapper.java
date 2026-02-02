package org.hdcd.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hdcd.board.Board;
import org.mybatis.spring.annotation.MapperScan;


@SuppressWarnings("unused")
@Mapper
public interface BoardMapper {
	
	int insert(Board board);
	
	
	List<Board> selectList(@Param("offset") int offset,@Param("pageSize") int pageSize);

	int selectCount();
	
	Board selectOne(@Param("boardNo") int boardNo);
	 
	int update(Board board);
	
	int delete(@Param("boardNo") int boardNo);
	
	int viewCnt(@Param("boardNo") int boardNo);
}
